package com.dormitory.controller.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.LostFoundController;
import com.dormitory.entity.LostFound;
import com.dormitory.service.LostFoundService;
import com.dormitory.service.StudentService;

@Controller("studentLostFoundController")
@RequestMapping(value="/student")
public class StudentLostFoundController  extends LostFoundController{
	@Resource
	private StudentService studentService;
	@RequestMapping(value = "listLostFoundByStudentId.do")
	@ResponseBody
	public String listLostFoundByStudentId(Long studentId,Integer pageIndex, Integer pageSize) {
		List<LostFound> list = lostFoundService.listByStudentId(studentId,pageIndex, pageSize);
		Integer total=lostFoundService.getSizeByStudentId(studentId);
		Map<String,Object> map=new HashMap<String,Object>(3);
		map.put("data", list);
		map.put("total", total);
		return toJSON(map);
	}
}
