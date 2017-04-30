package com.dormitory.controller.student;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.DeviceController;
import com.dormitory.entity.Device;
import com.dormitory.entity.Dormitory;
import com.dormitory.service.DormitoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller("studentDeviceController")
@RequestMapping(value="/student")
public class StudentDeviceController extends DeviceController{
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
	@ResponseBody
	public ModelAndView listDevice(@RequestParam(value = "studentId") Long studentId,Integer pageIndex,Integer pageSize, Model model) {
		Dormitory dormitory = dormitoryService.get(studentId);
		List<Device>list = deviceService.listDevice(pageIndex,pageSize);
		Integer total=deviceService.getSize();
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		return modelAndView;
	}
	
	
	
	protected String toJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(format);
		String result = null;
		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("序列化Announcement对象时出错", e);
			}
		}
		return result;
	}
}
