package com.dormitory.student.controller;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.entity.Student;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.EmailService;
import com.dormitory.service.StudentService;
import com.dormitory.service.dto.RegisterDTO;

@SessionAttributes({ "studentId", "dormitoryId" })
@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private StudentService studentService;
	@Resource
	private DormitoryService dormitoryService;
	@Resource
	private EmailService emailService;

	public StudentController() {

	}

	/*
	 * @InitBinder protected void initBinder(WebDataBinder binder) {
	 * binder.setValidator(new RegisterDTOValidator());//绑定自定义的校验器 }
	 */

	@RequestMapping("/register")
	public String register(@ModelAttribute(value = "register") @Valid RegisterDTO register, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().toString());
			return "redirect:/register";
		}
		if (!register.getPassword2().equals(register.getPassword())) {
			return "redirect:/register";
		}

		System.out.println("acccept registerDTO:" + register);
		// String page = studentService.saveOrUpdate(register);
		return "redirect:/student";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "studentId") String studentId,
			@RequestParam(value = "password") String password) {

		Student temp = studentService.get(Long.valueOf(studentId.trim()));
		System.out.println("temp:"+temp);
		if (temp != null) {
			if (password.trim().equals(temp.getPassword())) {
				return "redirect:/student";
			}else{
				return "redirect:/login";
			}
				
		}
		System.out.println("login fail");
		return "redirect:/login";
	}

	@RequestMapping(value = "/isStudentIdExisted", method = RequestMethod.GET)
	@ResponseBody
	public String isStudentIdExisted(@RequestParam(value = "studentId") String studentId) {
		Student student = studentService.get(Long.valueOf(studentId.trim()));
		return student != null ? "existed" : "unexisted";
	}

	@RequestMapping(value = "/isPasswordCorrect", method = RequestMethod.GET)
	@ResponseBody
	public String isPasswordCorrect(@RequestParam(value = "studentId") String studentId,
			@RequestParam(value = "password") String password) {
		Student student = studentService.get(Long.valueOf(studentId));
		if (student == null) {
			return "incorrect";
		}
		return student.getPassword().equals(password.trim()) ? "correct" : "incorrect";
	}

	@RequestMapping("/updatePassword")
	public String updatePassword(@RequestParam(value = "studentId")String studentId) {
		Student student=studentService.get(Long.valueOf(studentId));
		if(student==null){
			return "redirect:/error";
		}
		studentService.saveOrUpdate(student);
		return "redirect:/login";

	}

	@RequestMapping("/forgetPassword")
	public Map<String,String> forgetPassword(@RequestParam(value = "request") HttpServletRequest request,
			@RequestParam(value = "studentId") String studentId) {
		Long id = Long.valueOf(studentId.trim());
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
				+ "/";
		Student student = studentService.get(id);
		return emailService.sendEmail(student, basePath);
	}

	/**
	 * 找回链接已经发到邮箱了。进入邮箱点开链接 以下为链接检验代码，验证通过 跳转到修改密码界面,否则跳转到失败界面
	 */
	@RequestMapping(value = "/checkResetLink", method = RequestMethod.GET)
	public ModelAndView checkResetLink(String sid, String id) {
		ModelAndView model = new ModelAndView("redirect:/error");
		Map<String, String> map = emailService.checkResetLink(sid, Long.valueOf(id.trim()));
		if (map.get("status").equals("success")) {
			model.setViewName("/updatePassword"); // 返回到修改密码的界面
			model.addObject("studentId", id);
			return model;
		} else {
			model.addObject("msg", map.get("msg"));
			return model;
		}
	}
}
