package com.dormitory.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.dormitory.controller.RepairRecordController;

@Controller("adminRepairRecordController")
@RequestMapping(value = "/admin")
public class AdminRepairRecordController extends RepairRecordController {
	
}
