package com.dormitory.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.Announcement;
import com.dormitory.service.AnnouncementService;

@Controller
public abstract class AbstractAnnouncementController {
	@Resource
	protected AnnouncementService announcementService;
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	@RequestMapping(value = "/listAnnouncement.do")
	public ModelAndView listAnnouncement(@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		List<Announcement> list = announcementService.list(pageIndex, pageSize);
		modelAndView.addObject("announcement", list);
		return modelAndView;
	}

	@RequestMapping(value = "/listAnnouncementLimit.do")
	public ModelAndView listAnnouncementLimit(@RequestParam(value = "n") Integer n) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		List<Announcement> list = announcementService.listLimit(n);
		modelAndView.addObject("announcement", list);
		return modelAndView;
	}

	
}
