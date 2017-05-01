package com.dormitory.controller.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dormitory.controller.PostcardController;
import com.dormitory.entity.Postcard;
import com.dormitory.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentPostcardController extends PostcardController {
	@Resource
	private StudentService studentService;

	@RequestMapping(value = "listPostcardByStudentId.do")
	@ResponseBody
	public String listPostcardByStudentId(@RequestParam("studentId") Long studentId, @RequestParam("pageIndex") Integer pageIndex,
			@RequestParam("pageSize") Integer pageSize) {
		List<Postcard> list = postcardService.listByStudentId(studentId, pageIndex, pageSize);
		Integer total = postcardService.getSizeByStudentId(studentId);
		Integer count=getTotalPages(total, pageSize);
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("data", list);
		map.put("totalPage", count);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		return toJSON(map);
	}
	private int getTotalPages(Integer count ,Integer pageSize){
		int totalPages = 0;
		totalPages = (count%pageSize==0)?(count/pageSize):(count/pageSize+1);
		return totalPages;
	}
}
