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
import com.dormitory.dto.PostcardDTO;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Postcard;
import com.dormitory.entity.Student;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.StudentService;

@Controller
@RequestMapping(value = "/student")
public class StudentPostcardController extends PostcardController {
	@Resource
	private StudentService studentService;
	@Resource
	private DormitoryService dormitoryService;

	@RequestMapping(value = "listPostcardByStudentId.do")
	public ModelAndView listPostcardByStudentId(@RequestParam("studentId") Long studentId,
			@RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		Student student = studentService.get(studentId);
		Dormitory dormitory = dormitoryService.get(student.getDormitoryId());
		Integer buildingId = dormitory.getBuildingId();
		List<PostcardDTO> list = postcardService.listByBuildingId(buildingId, pageIndex, pageSize);
		Integer total = postcardService.getSizeByBuildingId(buildingId);
		Integer totalPage = getTotalPages(total, pageSize);
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.setViewName("studentAnnoucment/myPostCard");
		return modelAndView;
	}

}
