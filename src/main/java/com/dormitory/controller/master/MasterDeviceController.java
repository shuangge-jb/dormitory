package com.dormitory.controller.master;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dormitory.controller.DeviceController;

@Controller("masterDeviceController")
@RequestMapping(value="/master")
public class MasterDeviceController extends DeviceController{


}
