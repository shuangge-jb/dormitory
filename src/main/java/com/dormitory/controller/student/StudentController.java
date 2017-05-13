package com.dormitory.controller.student;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import org.springframework.web.servlet.view.RedirectView;

import com.dormitory.dto.student.StudentDTO;
import com.dormitory.entity.Building;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.service.BuildingService;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.EmailService;
import com.dormitory.service.FileService;
import com.dormitory.service.StudentService;
import com.fasterxml.jackson.databind.deser.impl.ExternalTypeHandler.Builder;

@SessionAttributes({ "studentId", "dormitoryId", "studentName" })
@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private StudentService studentService;
	@Resource
	private DormitoryService dormitoryService;
	@Resource
	private BuildingService buildingService;
	@Resource
	private EmailService emailService;
	@Resource
	private FileService fileService;

	private static final String IMG_DIR = "/images/";
	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	public StudentController() {

	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute(value = "register") @Valid StudentDTO register, BindingResult result,
			@RequestParam(value = "img") MultipartFile img, HttpServletRequest request, Model model) {
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
		modelAndView.setViewName("../../Reg_success_tip");
		setSessionValue(model, dormitory.getDormitoryId(), student.getStudentId(), student.getName());
		return modelAndView;
	}

	@RequestMapping(value = "/studentLogin.do", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(value = "id") Long studentId,
			@RequestParam(value = "password") String password, Model model) {
		ModelAndView modelAndView = new ModelAndView("../../login");// login不在WEB-INF/pages下，要访问父级目录
		Student temp = studentService.get(studentId);
		if (temp != null) {
			if (password.trim().equals(temp.getPassword())) {
				
				Dormitory dormitory = dormitoryService.get(studentId);
				setSessionValue(model, dormitory.getDormitoryId(), studentId, temp.getName());
			}
		}
		
			modelAndView.setViewName("../../homePage");
		
		return modelAndView;
	}

	@RequestMapping(value = "/isStudentIdExisted.do", method = RequestMethod.GET)
	@ResponseBody
	public String isStudentIdExisted(@RequestParam(value = "studentId") Long studentId) {
		Student student = studentService.get(studentId);
		return student != null ? "existed" : "unexisted";
	}

	@RequestMapping(value = "/isPasswordCorrect.do", method = RequestMethod.GET)
	@ResponseBody
	public String isPasswordCorrect(@RequestParam(value = "studentId") String studentId,
			@RequestParam(value = "password") String password) {
		Student student = studentService.get(Long.valueOf(studentId));
		if (student == null) {
			return "incorrect";
		}
		return student.getPassword().equals(password.trim()) ? "correct" : "incorrect";
	}

	@RequestMapping(value = "/updatePassword.do", method = RequestMethod.POST)
	public ModelAndView updatePassword(@RequestParam(value = "studentId") Long studentId,
			@RequestParam(value = "password") String password, Model model) {
		Student student = studentService.get(studentId);
		ModelAndView modelAndView = new ModelAndView();

		if (student == null) {
			modelAndView.setViewName("redirect:/error");
		} else {
			student.setPassword(password);
			studentService.saveOrUpdate(student);
			modelAndView.setViewName("");
			model.addAttribute("studentId", studentId);
			Integer dormitoryId = dormitoryService.get(studentId).getDormitoryId();
			model.addAttribute("dormitoryId", dormitoryId);
		}
		return modelAndView;
	}

	@RequestMapping(value = "/forgetPassword.do")
	public Map<String, String> forgetPassword(@RequestParam(value = "request") HttpServletRequest request,
			@RequestParam(value = "studentId") Long studentId) {

		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		Student student = studentService.get(studentId);
		return emailService.sendEmail(student, basePath);
	}

	/**
	 * 找回链接已经发到邮箱了。进入邮箱点开链接 以下为链接检验代码，验证通过 跳转到修改密码界面,否则跳转到失败界面
	 * 
	 * @param sid
	 * @param studentId
	 * @return
	 */
	@RequestMapping(value = "/checkResetLink.do", method = RequestMethod.GET)
	public ModelAndView checkResetLink(String sid, String studentId) {
		ModelAndView model = new ModelAndView("error");
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

	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(ModelMap model, SessionStatus status, HttpSession session) {
		session.removeAttribute("studentId");
	    session.removeAttribute("dormitoryId");
	    session.removeAttribute("studentName");
		status.setComplete();
		session.invalidate();
		RedirectView redirect = new RedirectView("/dormitory/homePage.jsp");
		redirect.setExposeModelAttributes(false);
		ModelAndView modelAndView= new ModelAndView(redirect, null);
		System.out.println("after logout.");
		return modelAndView;
	}

	@RequestMapping(value = "/getStudentInfo.do")
	public ModelAndView getStudentInfo(@RequestParam(value = "studentId") Long studentId) {
		StudentDTO studentDTO = new StudentDTO();
		Student student = studentService.get(studentId);
		if (student == null) {
			return new ModelAndView("../../login");
		}
		studentDTO.setStudent(student);
		Dormitory dormitory = dormitoryService.get(studentId);
		Building building = buildingService.get(dormitory.getBuildingId());
		studentDTO.setBuildingName(building.getBuildngName());
		studentDTO.setRoom(dormitory.getRoom());
		ModelAndView modelAndView = new ModelAndView("");
		System.out.println("response studentDTO:" + studentDTO);
		modelAndView.addObject("student", studentDTO);
		return modelAndView;
	}

	@RequestMapping(value = "/updateStudentInfo.do", method = RequestMethod.POST)
	public ModelAndView updateStudentInfo(@RequestParam(value = "img") MultipartFile img, HttpServletRequest request,
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

	private void setSessionValue(Model model, Integer dormitoryId, Long studentId, String studentName) {
		model.addAttribute("studentId", studentId);
		model.addAttribute("dormitoryId", dormitoryId);
		model.addAttribute("studentName", studentName);
	}

}
