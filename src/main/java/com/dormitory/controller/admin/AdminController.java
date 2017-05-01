package com.dormitory.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dormitory.service.MasterService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private MasterService adminService;

	@RequestMapping("/login.do")
	public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
		if (name.equals("admin") && password.equals("admin")) {
			return "adminMain";
		} else {
			return "redirect:/login";
		}

	}
}
