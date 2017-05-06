package com.dormitory.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.AnnouncementController;
import com.dormitory.entity.Announcement;

@Controller("adminAnnouncementController")
@RequestMapping(value = "/admin")
public class AdminAnnouncementController extends AnnouncementController{
	
	
	@RequestMapping(value = "/removeAnnouncement.do", method = RequestMethod.POST)
	public ModelAndView removeAnnouncement(@RequestParam(value = "announcement")  Integer announcementId) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		Announcement announcement=announcementService.get(announcementId);
		announcementService.remove(announcement);
		
		// TODO
		modelAndView.setViewName("announcement");
		modelAndView.addObject("status", REMOVE_SUCCESS);
		return modelAndView;
	}
}
