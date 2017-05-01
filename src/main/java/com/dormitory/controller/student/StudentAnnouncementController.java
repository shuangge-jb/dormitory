package com.dormitory.controller.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.AnnouncementController;
import com.dormitory.entity.Announcement;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.service.AnnouncementService;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.StudentService;

@Controller("studentAnnouncementController")
@RequestMapping(value = "/student")
public class StudentAnnouncementController extends AnnouncementController{
	@Resource
	private StudentService studentService;
	@Resource
	private DormitoryService dormitoryService;
	
	@RequestMapping(value = "/listAnnouncementByStudentId.do")
	@ResponseBody
	public String listAnnouncementByStudentId(@RequestParam(value = "studentId")Long studentId,@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		Student student=studentService.get(studentId);
		Dormitory dormitory=dormitoryService.get(student.getDormitoryId());
		Integer buildingId=dormitory.getBuildingId();
		List<Announcement>list = announcementService.listByBuildingId(buildingId,pageIndex, pageSize);
		Integer total=announcementService.getSizeByBuildingId(buildingId);
		Map<String,Object>map=new HashMap<String,Object>(3);
		map.put("data", list);
		map.put("total", total);
		return toJSON(map);
	}

	

	
}
