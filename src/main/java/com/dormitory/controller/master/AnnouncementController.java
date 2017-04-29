package com.dormitory.controller.master;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.AbstractAnnouncementController;
import com.dormitory.entity.Announcement;

@Controller("masterAnnouncementController")
@RequestMapping(value = "/master")
public class AnnouncementController extends AbstractAnnouncementController{
	@RequestMapping(value = "/saveOrUpdateAnnouncement.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateAnnouncement(@ModelAttribute(value = "announcement")@Valid  Announcement announcement,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		if(result.hasErrors()){
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		announcementService.saveOrUpdate(announcement);
		// TODO
		modelAndView.setViewName("announcement");
		modelAndView.addObject("status", OPERATE_SUCCESS);
		return modelAndView;
	}
	
	@RequestMapping(value = "/removeAnnouncement.do", method = RequestMethod.POST)
	public ModelAndView removeAnnouncement(@ModelAttribute(value = "announcement")@Valid  Announcement announcement,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		announcementService.remove(announcement);
		if(result.hasErrors()){
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		// TODO
		modelAndView.setViewName("announcement");
		modelAndView.addObject("status", REMOVE_SUCCESS);
		return modelAndView;
	}
}
