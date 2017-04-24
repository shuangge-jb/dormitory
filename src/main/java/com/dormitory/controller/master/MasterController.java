package com.dormitory.controller.master;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dormitory.service.MasterService;

@Controller
@RequestMapping(value = "master")
public class MasterController {
	@Resource
	private MasterService masterService;

}
