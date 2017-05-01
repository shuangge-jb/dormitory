package com.dormitory.controller.master;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.PostcardController;
import com.dormitory.entity.Postcard;
import com.dormitory.service.MasterService;
import com.dormitory.service.PostcardService;

@Controller
@RequestMapping(value = "/master")
public class MasterPostcardController extends PostcardController {
	@Resource
	private MasterService masterService;

	@RequestMapping(value = "saveOrUpdatePostcard.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdatePostcard(@ModelAttribute(value = "postcard") @Valid Postcard postcard,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		postcardService.saveOrUpdate(postcard);
		return modelAndView;
	}

	@RequestMapping(value = "removePostcard.do", method = RequestMethod.POST)
	public ModelAndView removePostcard(@RequestParam(value = "postcardId") Integer postcardId) {
		ModelAndView modelAndView = new ModelAndView();
		Postcard postcard = postcardService.get(postcardId);
		postcardService.remove(postcard);
		return modelAndView;
	}
}
