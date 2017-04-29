package com.dormitory.controller.master;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.student.StudentController;
import com.dormitory.dto.master.MasterDTO;
import com.dormitory.dto.student.StudentDTO;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Master;
import com.dormitory.entity.Student;
import com.dormitory.service.EmailService;
import com.dormitory.service.FileService;
import com.dormitory.service.MasterService;

@Controller
@RequestMapping(value = "/master")
@SessionAttributes({ "studentId" })
public class MasterController {
	@Resource
	private MasterService masterService;
	@Resource
	private EmailService emailService;
	@Resource
	private FileService fileService;
	private static final String IMG_DIR = "/images/";
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute(value = "register") @Valid MasterDTO masterDTO, BindingResult result,
			@RequestParam(value = "img") MultipartFile img, HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView("../../jsp/register");// 默认为跳转回注册页面
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().toString());
			return modelAndView;
		}
		if (!masterDTO.getPassword2().equals(masterDTO.getPassword())) {
			return modelAndView;
		}
		// 检查图片文件
		System.out.println("img:" + img);
		if (img == null || img.isEmpty()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("文件为空：");
			}
			return modelAndView;
		}
		System.out.println("img name:" + img.getOriginalFilename() + " ends with jpg:"
				+ img.getOriginalFilename().endsWith(".jpg"));
		if (!(img.getOriginalFilename().toLowerCase().endsWith(".jpg"))) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("img参数异常：");
			}
			return modelAndView;
		}
		// 检查是否已注册
		Master temp = masterService.get(masterDTO.getMasterId());
		if (temp != null) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("已注册");
			}
			modelAndView.addObject("status", "已注册");
			return modelAndView;
		}
		System.out.println("acccept masterDTO:" + masterDTO);
		
		fileService.saveFile(request, IMG_DIR,img);
		// 保存宿管信息
		
		return modelAndView;
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "id") Integer masterId,
			@RequestParam(value = "password") String password, Model model) {
		ModelAndView modelAndView = new ModelAndView("../../jsp/login");// login不在WEB-INF/pages下，要访问父级目录
		Master temp = masterService.get(masterId);
		if (temp != null) {
			if (password.trim().equals(temp.getPassword())) {
				modelAndView.setViewName("redirect:listDevice.do");
				
				setSessionValue(model, masterId);
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/isMasterIdExisted.do", method = RequestMethod.GET)
	@ResponseBody
	public String isMasterIdExisted(@RequestParam(value = "masterId") Integer masterId) {
		Master master = masterService.get(masterId);
		return master != null ? "existed" : "unexisted";
	}

	@RequestMapping(value = "/isPasswordCorrect.do", method = RequestMethod.GET)
	@ResponseBody
	public String isPasswordCorrect(@RequestParam(value = "masterId") Integer masterId,
			@RequestParam(value = "password") String password) {
		Master master = masterService.get(masterId);
		if (master == null) {
			return "incorrect";
		}
		return master.getPassword().equals(password.trim()) ? "correct" : "incorrect";
	}

	@RequestMapping("/updatePassword.do")
	public ModelAndView updatePassword(@RequestParam(value = "masterId") Integer masterId, Model model) {
		Master master = masterService.get(masterId);
		ModelAndView modelAndView = new ModelAndView();
		
		if (master == null) {
			modelAndView.setViewName("redirect:/error");
		} else {
			masterService.saveOrUpdate(master);
			modelAndView.setViewName("redirect:listdevicedo");
			setSessionValue(model, master.getMasterId());
			
		}
		return modelAndView;
	}

//	@RequestMapping("/forgetPassword.do")
//	public Map<String, String> forgetPassword(@RequestParam(value = "request") HttpServletRequest request,
//			@RequestParam(value = "masterId") Integer masterId) {
//
//		String path = request.getContextPath();
//		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
//				+ "/";
//		Master master = masterService.get(masterId);
//		return emailService.sendEmail(master, basePath);
//	}

	/**
	 * 找回链接已经发到邮箱了。进入邮箱点开链接 以下为链接检验代码，验证通过 跳转到修改密码界面,否则跳转到失败界面
	 * 
	 * @param sid
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value = "/checkResetLink.do", method = RequestMethod.GET)
	public ModelAndView checkResetLink(String sid, String studentId) {
		ModelAndView model = new ModelAndView("redirect:/error");
		Map<String, String> map = emailService.checkResetLink(sid, Long.valueOf(studentId.trim()));
		if (map.get("status").equals("success")) {
			model.setViewName("updatePassword"); // 返回到修改密码的界面
			model.addObject("studentId", studentId);
			return model;
		} else {
			model.addObject("msg", map.get("msg"));
			return model;
		}
	}

	

	

	@RequestMapping("/logout.do")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/index.jsp";
	}

	@RequestMapping(value = "/getPersonalInfo.do", method = RequestMethod.GET)
	public ModelAndView getPersonalInfo(@RequestParam(value = "masterId") Integer masterId) {
		MasterDTO masterDTO = new MasterDTO();
		Master master = masterService.get(masterId);
		if(master==null){
			return new ModelAndView("../../jsp/login");
		}
		masterDTO.setMaster(master);
		ModelAndView modelAndView = new ModelAndView("master");
		System.out.println("response masterDTO:"+masterDTO);
		modelAndView.addObject("master", masterDTO);
		return modelAndView;
	}

	private void setSessionValue(Model model, Integer masterId) {
		model.addAttribute("masterId", masterId);
	}
}
