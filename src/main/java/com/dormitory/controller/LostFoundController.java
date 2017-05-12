package com.dormitory.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.dormitory.entity.LostFound;
import com.dormitory.service.LostFoundService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LostFoundController {
	@Resource
	protected LostFoundService lostFoundService;
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final String ERROR_INPUT="输入的参数有误";
	protected static final Logger LOGGER = LoggerFactory.getLogger(LostFoundController.class);

	@RequestMapping(value = "listLostFound.do")
	public ModelAndView listLostFound(@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		List<LostFound> list = lostFoundService.list(pageIndex, pageSize);
		Integer total = lostFoundService.getSize();
		Integer totalPage=getTotalPages(total, pageSize);
        modelAndView.addObject("data", list);
        modelAndView.addObject("total", total);
        modelAndView.addObject("totalPages", totalPage);
        modelAndView.addObject("pageIndex", pageIndex);
        modelAndView.addObject("pageSize", pageSize);
        modelAndView.addObject("result", list!=null);	
        modelAndView.setViewName("studentAnnoucment/lostFound");
		return modelAndView;
	}
	
	@RequestMapping(value = "saveOrUpdateLostFound.do",method=RequestMethod.POST)
	public ModelAndView saveOrUpdateLostFound(@ModelAttribute(value="lostFound")@Valid LostFound lostFound,BindingResult result){
		ModelAndView modelAndView = new ModelAndView("homePage");
		if(result.hasErrors()){
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", ERROR_INPUT);
			return modelAndView;
		}
		lostFoundService.saveOrUpdate(lostFound);
		modelAndView.addObject("status", OPERATE_SUCCESS);
		return modelAndView;
	}
	@RequestMapping(value = "removeLostFound.do",method=RequestMethod.POST)
	public ModelAndView removeLostFound(@RequestParam(value="lostFound") Integer lostFoundId){
		ModelAndView modelAndView = new ModelAndView("homePage");
		
		lostFoundService.remove(lostFoundId);
		modelAndView.addObject("status", REMOVE_SUCCESS);
		return modelAndView;
	}
	
	@RequestMapping(value = "getLostFound.do")
	@ResponseBody
	public String getLostFound(@RequestParam(value = "lostFoundId") Integer lostFoundId) {
		LostFound lost = lostFoundService.get(lostFoundId);
		return toJSON(lost);
	}
	protected int getTotalPages(Integer count ,Integer pageSize){
		if(pageSize==null){
			pageSize=10;
		}
		int totalPages = 0;
		totalPages = (count%pageSize==0)?(count/pageSize):(count/pageSize+1);
		return totalPages;
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
	
}
