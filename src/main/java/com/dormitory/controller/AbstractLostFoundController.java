package com.dormitory.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.LostFound;
import com.dormitory.service.LostFoundService;

@Controller
public abstract class AbstractLostFoundController {
	@Resource
	protected LostFoundService lostFoundService;
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	@RequestMapping(value = "listLostFound.do")
	public ModelAndView listLostFound(Integer pageIndex, Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		List<LostFound> list = lostFoundService.list(pageIndex, pageSize);
		modelAndView.addObject("lostFound", list);
		return modelAndView;
	}
	@RequestMapping(value = "listLostFoundByStudentId.do")
	public ModelAndView listLostFoundByStudentId(Long studentId,Integer pageIndex, Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		List<LostFound> list = lostFoundService.listByStudentId(studentId,pageIndex, pageSize);
		modelAndView.addObject("lostFound", list);
		return modelAndView;
	}
}
