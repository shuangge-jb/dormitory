package com.dormitory.controller.master;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.LostFoundController;
import com.dormitory.entity.LostFound;
import com.dormitory.service.LostFoundService;

@Controller("masterLostFoundController")
@RequestMapping(value="/master")
public class MasterLostFoundController extends LostFoundController{
	

	@RequestMapping(value = "saveOrUpdateLostFound.do",method=RequestMethod.POST)
	public ModelAndView saveOrUpdateLostFound(@ModelAttribute(value="lostFound")@Valid LostFound lostFound){
		ModelAndView modelAndView = new ModelAndView("homePage");
		lostFoundService.saveOrUpdate(lostFound);
		return modelAndView;
	}
	@RequestMapping(value = "removeLostFound.do",method=RequestMethod.POST)
	public ModelAndView removeLostFound(@ModelAttribute(value="lostFound")@Valid LostFound lostFound){
		ModelAndView modelAndView = new ModelAndView("homePage");
		lostFoundService.saveOrUpdate(lostFound);
		return modelAndView;
	}
}
