package com.dormitory.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dormitory.controller.LostFoundController;

@Controller("adminLostFoundController")
@RequestMapping(value="/admin")
public class AdminLostFoundController extends LostFoundController{
	
}
