package com.dormitory.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dormitory.controller.PostcardController;
import com.dormitory.service.AdminService;

@Controller
@RequestMapping(value = "/admin")
public class AdminPostcardController extends PostcardController {
	@Resource
	private AdminService adminService;

}
