package com.dormitory.controller.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.LostFoundController;
import com.dormitory.entity.LostFound;
import com.dormitory.service.LostFoundService;

@Controller("studentLostFoundController")
public class StudentLostFoundController  extends LostFoundController{
	
}
