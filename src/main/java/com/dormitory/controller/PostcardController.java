package com.dormitory.controller;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.Postcard;
import com.dormitory.service.PostcardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PostcardController {
	@Resource
	protected PostcardService postcardService;
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final String ERROR_INPUT="输入的参数有误";
	protected static final Logger LOGGER = LoggerFactory.getLogger(PostcardController.class);

	@RequestMapping(value = "getPostcard.do")
	@ResponseBody
	public String getPostcard(@RequestParam(value = "postcardId") Integer postcardId) {
		Postcard card = postcardService.get(postcardId);
		return toJSON(card);
	}
	@RequestMapping(value = "saveOrUpdatePostcard.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdatePostcard(@ModelAttribute(value = "postcard") @Valid Postcard postcard,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", ERROR_INPUT);
			return modelAndView;
		}
		postcardService.saveOrUpdate(postcard);
		return modelAndView;
	}

	@RequestMapping(value = "removePostcard.do", method = RequestMethod.POST)
	public ModelAndView removePostcard(@RequestParam(value = "postcardId") Integer postcardId) {
		ModelAndView modelAndView = new ModelAndView();
		postcardService.remove(postcardId);
		return modelAndView;
	}
	protected String toJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(format);
		String result = null;
		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("序列化LostFound对象时出错", e);
			}
		}
		return result;
	}
	protected int getTotalPages(Integer count ,Integer pageSize){
		if(pageSize==null){
			pageSize=10;
		}
		int totalPages = 0;
		totalPages = (count%pageSize==0)?(count/pageSize):(count/pageSize+1);
		return totalPages;
	}
}
