package com.dormitory.controller.student;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.AbstractDeviceController;
import com.dormitory.entity.Device;
import com.dormitory.entity.Dormitory;
import com.dormitory.service.DormitoryService;

@Controller("studentDeviceController")
@RequestMapping(value="/student")
public class DeviceController extends AbstractDeviceController{
	@Resource
	private DormitoryService dormitoryService;
	/**
	 * 查找所在宿舍的物品
	 * 
	 * @param dormitoryId
	 * @return
	 * @author guo.junbao
	 */
	@RequestMapping(value = { "listDevice.do" }, method = RequestMethod.GET)
	public ModelAndView listDevice(@RequestParam(value = "studentId") Long studentId,Integer pageIndex,Integer pageSize, Model model) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		Dormitory dormitory = dormitoryService.get(studentId);
		List<Device> list = deviceService.listByDormitoryId(dormitory.getDormitoryId());
		modelAndView.addObject("list", list);

		return modelAndView;
	}

}
