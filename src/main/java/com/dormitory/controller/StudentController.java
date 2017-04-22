package com.dormitory.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.StudentService;
import com.dormitory.service.dto.LoginDTO;
import com.dormitory.service.dto.RegisterDTO;

@SessionAttributes({ "studentId", "dormitoryId" })
@RequestMapping("/student")
@Controller
public class StudentController {
	@Resource
	private StudentService studentService;
	@Resource
	private DormitoryService dormitoryService;

	public StudentController() {

	}

	@RequestMapping("/register")
	public String register(@RequestParam(value = "register") @Valid RegisterDTO register, BindingResult result) {
		if (result.hasErrors()) {

			return "redirect:/register";
		}
		String page = studentService.saveOrUpdate(register);
		return "redirect:/student";
	}
	@RequestMapping("/login")
	public String login(@RequestParam(value = "student") @Valid LoginDTO loginDTO, BindingResult result){
		if (result.hasErrors()) {

			return "redirect:/login";
		}
		return "/student";
		
	}
	@RequestMapping("/updatePassword")
	public String updatePassword(@RequestParam(value = "student") LoginDTO loginDTO){
		return null;
		
	}
	@RequestMapping("/findPassword")
	public String findPassword(@RequestParam(value = "student") LoginDTO loginDTO){
		return null;
		
	}
}
