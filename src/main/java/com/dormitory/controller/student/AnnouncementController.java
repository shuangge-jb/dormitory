package com.dormitory.controller.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.AbstractAnnouncementController;
import com.dormitory.entity.Announcement;
import com.dormitory.service.AnnouncementService;

@Controller("studentAnnouncementController")
@RequestMapping(value = "/student")
public class AnnouncementController extends AbstractAnnouncementController{
	

	
}
