package com.dormitory.controller.master;

import java.util.List;
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

import com.dormitory.dto.master.MasterDTO;
import com.dormitory.dto.student.StudentDTO;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Master;
import com.dormitory.entity.Student;
import com.dormitory.service.BuildingService;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.EmailService;
import com.dormitory.service.FileService;
import com.dormitory.service.MasterService;
import com.dormitory.service.StudentService;

@Controller
@RequestMapping(value = "/master")
@SessionAttributes({ "masterId", "masterName", "buildingId" })
public class MasterController {
	@Resource
	private MasterService masterService;
	@Resource
	private EmailService emailService;
	@Resource
	private FileService fileService;
	@Resource
	private StudentService studentService;
	@Resource
	private DormitoryService dormitoryService;
	@Resource
	private BuildingService buildingService;
	private static final String IMG_DIR = "/images/";
	private static final String ERROR_PAGE = "error";
	private static final Logger LOGGER = LoggerFactory.getLogger(MasterController.class);

	@RequestMapping(value = "/masterLogin.do", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "id") Integer masterId,
			@RequestParam(value = "password") String password, Model model) {
		ModelAndView modelAndView = new ModelAndView();// login不在WEB-INF/pages下，要访问父级目录
		Master temp = masterService.get(masterId);
		if (temp != null) {
			if (password.trim().equals(temp.getPassword())) {
				modelAndView.setViewName("masterMain");
				setSessionValue(model, temp);
				return modelAndView;
			} else {

				modelAndView.setViewName("../../master/login");
				modelAndView.addObject("status", "密码错误");
			}

		} else {
			modelAndView.setViewName("../../master/login.jsp");
			modelAndView.addObject("status", "用户名不存在");
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

	@RequestMapping("/updateMasterPassword.do")
	public ModelAndView updatePassword(@RequestParam(value = "masterId") Integer masterId,
			@RequestParam(value = "password") String password, Model model) {
		Master master = masterService.get(masterId);
		ModelAndView modelAndView = new ModelAndView("masterList/changePassword");
		if (master == null) {
			return new ModelAndView("../../login");
		} else {
			master.setPassword(password);
			masterService.updatePassword(master);
			setSessionValue(model, master);
			modelAndView.addObject("status", "修改成功");
		}
		return modelAndView;
	}

	// @RequestMapping("/forgetPassword.do")
	// public Map<String, String> forgetPassword(@RequestParam(value =
	// "request") HttpServletRequest request,
	// @RequestParam(value = "masterId") Integer masterId) {
	//
	// String path = request.getContextPath();
	// String basePath = request.getScheme() + "://" + request.getServerName() +
	// ":" + request.getServerPort() + path
	// + "/";
	// Master master = masterService.get(masterId);
	// return emailService.sendEmail(master, basePath);
	// }

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

	@RequestMapping(value = "/getMasterInfo.do", method = RequestMethod.GET)
	public ModelAndView getPersonalInfo(@RequestParam(value = "masterId") Integer masterId) {
		MasterDTO masterDTO = new MasterDTO();
		Master master = masterService.get(masterId);
		if (master == null) {
			return new ModelAndView("../../login");
		}
		masterDTO.setMaster(master);
		masterDTO.setBuildingName(buildingService.get(master.getBuildingId()).getBuildngName());
		ModelAndView modelAndView = new ModelAndView("masterList/getMasterInfo");
		System.out.println("response masterDTO:" + masterDTO);
		modelAndView.addObject("master", masterDTO);
		return modelAndView;
	}

	private void setSessionValue(Model model, Master master) {
		model.addAttribute("masterId", master.getMasterId());
		model.addAttribute("masterName", master.getName());
		model.addAttribute("buildingId", master.getBuildingId());
	}

	@RequestMapping(value = "/saveStudent.do", method = RequestMethod.POST)
	public ModelAndView saveStudent(@ModelAttribute(value = "register") @Valid StudentDTO register,
			BindingResult result, @RequestParam(value = "img") MultipartFile img, HttpServletRequest request,
			Model model) {
		ModelAndView modelAndView = new ModelAndView("../../reg");// 默认为跳转回注册页面
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().toString());
			return modelAndView;
		}
		if (!register.getPassword2().equals(register.getPassword())) {
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
		Student temp = studentService.get(register.getStudentId());
		if (temp != null) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("已注册");
			}
			modelAndView.addObject("status", "已注册");
			return modelAndView;
		}
		System.out.println("acccept registerDTO:" + register);
		// 保存宿舍信息(如果宿舍不存在，就添加进去，否则不添加)
		Dormitory dormitory = dormitoryService.save(register.getBuildingName(), register.getRoom());
		fileService.saveFile(request, IMG_DIR, img);
		// 保存学生信息
		Student student = register.getStudent();
		student.setDormitoryId(dormitory.getDormitoryId());
		String imgName = fileService.getFilePath(request, IMG_DIR, img);
		System.out.println("--imgName:" + imgName);
		student.setImgPath(imgName);
		studentService.saveOrUpdate(student);
		modelAndView.setViewName("");
		return modelAndView;
	}

	@RequestMapping(value = "/updateStudent.do", method = RequestMethod.POST)
	public ModelAndView updateStudent(@RequestParam(value = "img") MultipartFile img, HttpServletRequest request,
			@ModelAttribute(value = "studentDTO") @Valid StudentDTO studentDTO, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("student");
		if (result.hasErrors()) {
			modelAndView.setViewName("");
			return modelAndView;
		}
		Student student = studentDTO.getStudent();
		Dormitory dormitory = dormitoryService.save(studentDTO.getBuildingName(), studentDTO.getRoom());
		student.setDormitoryId(dormitory.getDormitoryId());
		// 新上传照片时，保存照片，更改照片路径
		if (img.getSize() > 0) {
			fileService.saveFile(request, IMG_DIR, img);
			String imgName = fileService.getFilePath(request, IMG_DIR, img);
			System.out.println("--imgName:" + imgName);
			student.setImgPath(imgName);
		} else {
			// 没有上传照片时，用旧的照片路径
			Student old = studentService.get(studentDTO.getStudentId());
			student.setImgPath(old.getImgPath());
		}
		studentService.saveOrUpdate(student);
		return modelAndView;
	}

	@RequestMapping(value = "removeStudent.do", method = RequestMethod.GET)
	public ModelAndView removeStudent(@RequestParam(value = "studentId") Long studentId,
			@RequestParam(value = "masterId") Integer masterId, @RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {

		studentService.remove(studentId);
		ModelAndView modelAndView = new ModelAndView("forward:forwardListStudent.do");
		modelAndView.addObject("masterId", masterId);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		return modelAndView;
	}

	@RequestMapping(value = "/forwardChangePassword.do")
	public ModelAndView forwardAddAnnouncement() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("masterList/changePassword");
		return modelAndView;
	}

	@RequestMapping(value = "/forwardListStudent.do")
	public ModelAndView forwardListStudent(@RequestParam(value = "masterId") Integer masterId,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("masterList/listStudents");
		Master master = masterService.get(masterId);
		Integer buildingId = master.getBuildingId();
		List<StudentDTO> list = studentService.listByBuildingId(buildingId, pageIndex, pageSize);
		Integer total = studentService.getSizeByBuildingId(buildingId);
		Integer totalPage = getTotalPages(total, pageSize);
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		return modelAndView;
	}

	protected int getTotalPages(Integer count, Integer pageSize) {
		if (pageSize == null) {
			pageSize = 10;
		}
		int totalPages = 0;
		totalPages = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
		return totalPages;
	}
}
