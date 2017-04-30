package com.dormitory.controller.admin;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.LostFoundController;
import com.dormitory.entity.LostFound;

@Controller("adminLostFoundController")
@RequestMapping(value="/admin")
public class AdminLostFoundController extends LostFoundController{
	@RequestMapping(value = "saveOrUpdateLostFound.do",method=RequestMethod.POST)
	public ModelAndView saveOrUpdateLostFound(@ModelAttribute(value="lostFound")@Valid LostFound lostFound,BindingResult result){
		ModelAndView modelAndView = new ModelAndView("homePage");
		if(result.hasErrors()){
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		lostFoundService.saveOrUpdate(lostFound);
		modelAndView.addObject("status", OPERATE_SUCCESS);
		return modelAndView;
	}
	@RequestMapping(value = "removeLostFound.do",method=RequestMethod.POST)
	public ModelAndView removeLostFound(@ModelAttribute(value="lostFound")@Valid LostFound lostFound,BindingResult result){
		ModelAndView modelAndView = new ModelAndView("homePage");
		if(result.hasErrors()){
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		lostFoundService.saveOrUpdate(lostFound);
		modelAndView.addObject("status", REMOVE_SUCCESS);
		return modelAndView;
	}
}
