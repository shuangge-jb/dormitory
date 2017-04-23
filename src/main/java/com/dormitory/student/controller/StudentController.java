package com.dormitory.student.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.StudentService;
import com.dormitory.service.dto.LoginDTO;
import com.dormitory.service.dto.RegisterDTO;
import com.dormitory.validator.ArticleDTOValidator;
import com.dormitory.validator.RegisterDTOValidator;

@SessionAttributes({ "studentId", "dormitoryId" })
@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private StudentService studentService;
	@Resource
	private DormitoryService dormitoryService;

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
			@RequestParam(value = "name") String password) {

		Student temp = studentService.get(Long.valueOf(studentId.trim()));
		if (temp != null) {
			if (password.trim() == temp.getPassword()) {
				return "redirect:/student";
			}
		}
		System.out.println("login success");
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
	public String updatePassword(@ModelAttribute(value = "student") LoginDTO loginDTO) {
		return null;

	}

	@RequestMapping("/findPassword")
	public String findPassword(@ModelAttribute(value = "student") LoginDTO loginDTO) {
		return null;

	}
}
