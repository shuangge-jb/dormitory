package com.dormitory.controller.student;

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
import com.dormitory.service.AnnouncementService;

@Controller("studentAnnouncementController")
@RequestMapping(value = "/student")
public class StudentAnnouncementController extends AnnouncementController{
	@RequestMapping(value = "/listAnnouncement.do")
	@ResponseBody
	public String listAnnouncement(@RequestParam(value = "studentId")Long studentId,@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		Map<String,Object>map = announcementService.list(pageIndex, pageSize);
		return toJSON(map);
	}

	@RequestMapping(value = "/listAnnouncementLimit.do")
	@ResponseBody
	public String listAnnouncementLimit(@RequestParam(value = "n") Integer n) {
		List<Announcement> list = announcementService.listLimit(n);
		
		return toJSON(list);
	}

	
}
