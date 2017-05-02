package com.dormitory.controller;

import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.Device;
import com.dormitory.entity.Interface;
import com.dormitory.entity.Paramater;
import com.dormitory.service.DeviceService;
import com.dormitory.service.HTTPService;
import com.dormitory.service.InterfaceService;
import com.dormitory.service.ParamaterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DeviceController {
	protected static final String IMG_DIR = "/images/";
	protected static final String MODEL_DIR = "/models/";
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final String ERROR_INPUT="输入的参数有误";
	protected static final String ERROR_PAGE_SIZE="页大小不能为0";
	protected static final Logger LOGGER = LoggerFactory.getLogger(DeviceController.class);
	@Resource
	protected DeviceService deviceService;
	@Resource
	protected InterfaceService interfaceService;
	@Resource
	protected ParamaterService paramaterService;
	@Resource
	protected HTTPService httpService;
	
	@RequestMapping(value = "listDevice.do")
	public ModelAndView listDevice(@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		if(pageIndex==null||pageIndex<=0||pageSize==null||pageSize==0){
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", ERROR_PAGE_SIZE);
			return modelAndView;
		}
		List<Device> list = deviceService.list(pageIndex, pageSize);
		Long total = deviceService.getSize();
		
		Long totalPage=getTotalPages(total, pageSize);
		modelAndView.addObject("data", list);
		modelAndView.addObject("total",total);
		modelAndView.addObject("totalPages",totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("result", list!=null);
		return modelAndView;
	}
	private long getTotalPages(Long count ,Integer pageSize){
		if(pageSize==null){
			pageSize=10;
		}
		long totalPages = 0;
		totalPages = (count%pageSize==0)?(count/pageSize):(count/pageSize+1);
		return totalPages;
	}
	private int getTotalPages(Integer count ,Integer pageSize){
		if(pageSize==null){
			pageSize=10;
		}
		int totalPages = 0;
		totalPages = (count%pageSize==0)?(count/pageSize):(count/pageSize+1);
		return totalPages;
	}
	@RequestMapping(value = "listInterfaceByDeviceId.do")
	public ModelAndView listInterfaceByDeviceId(@RequestParam(value = "deviceId") Long deviceId,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		if(pageIndex==null||pageIndex<=0||pageSize==null||pageSize==0){
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", ERROR_PAGE_SIZE);
			return modelAndView;
		}
		List<Interface> list = interfaceService.listByDeviceId(deviceId, pageIndex, pageSize);
		Integer total = interfaceService.getSizeByDeviceId(deviceId);
		
		Integer totalPage=getTotalPages(total, pageSize);
		modelAndView.addObject("data", list);
		modelAndView.addObject("total",total);
		modelAndView.addObject("totalPages",totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("result", list!=null);
		return modelAndView;
	}

	@RequestMapping(value = "listParamByInterfaceId.do")
	public ModelAndView listParamByInterfaceId(@RequestParam(value = "interfaceId") Integer interfaceId,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		if(pageIndex==null||pageIndex<=0||pageSize==null||pageSize==0){
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", ERROR_PAGE_SIZE);
			return modelAndView;
		}
		List<Paramater> list = paramaterService.listByInterfaceId(interfaceId, pageIndex, pageSize);
		Integer total = paramaterService.getSizeByInterfaceId(interfaceId);
		
		Integer totalPage=getTotalPages(total, pageSize);
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages",totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("result", list!=null);
		return modelAndView;
	}

	@RequestMapping(value = "getDevice.do")
	@ResponseBody
	public String getDevice(@RequestParam(value = "deviceId") Long deviceId) {
		Device device = deviceService.get(deviceId);
		return toJSON(device);
	}

	@RequestMapping(value = "getInterface.do")
	@ResponseBody
	public String getInterface(@RequestParam(value = "interfaceId") Integer interfaceId) {
		Interface face = interfaceService.get(interfaceId);
		return toJSON(face);
	}

	@RequestMapping(value = "getParamater.do")
	@ResponseBody
	public String getParamater(@RequestParam(value = "paramaterId") Integer paramaterId) {
		Paramater paramater = paramaterService.get(paramaterId);
		return toJSON(paramater);
	}

	protected String toJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(format);
		String result = null;
		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("序列化对象时出错", e);
			}
		}
		return result;
	}
	

}
