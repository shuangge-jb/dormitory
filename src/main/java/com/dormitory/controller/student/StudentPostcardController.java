package com.dormitory.controller.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.PostcardController;
import com.dormitory.entity.Postcard;
import com.dormitory.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentPostcardController extends PostcardController {
	@Resource
	private StudentService studentService;

	@RequestMapping(value = "listPostcardByStudentId.do")
	public ModelAndView listPostcardByStudentId(@RequestParam("studentId") Long studentId, @RequestParam("pageIndex") Integer pageIndex,
			@RequestParam("pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		List<Postcard> list = postcardService.listByStudentId(studentId, pageIndex, pageSize);
		Integer total = postcardService.getSizeByStudentId(studentId);
		Integer totalPage=getTotalPages(total, pageSize);
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("result", list!=null);
		modelAndView.setViewName("studentAnnoucment/myPostCard");
		return modelAndView;
	}
	
}
