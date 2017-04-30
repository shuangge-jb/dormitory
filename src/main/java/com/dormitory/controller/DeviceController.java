package com.dormitory.controller;

import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
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
import com.dormitory.service.DeviceService;
import com.dormitory.service.HTTPService;
import com.dormitory.service.InterfaceService;
import com.dormitory.service.ParamaterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DeviceController {
	protected static final String MODEL_DIR = "/models/";
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	@Resource
	protected DeviceService deviceService;
	@Resource
	protected InterfaceService interfaceService;
	@Resource
	protected ParamaterService paramaterService;
	@Resource
	protected HTTPService httpService;

	@RequestMapping(value = "listInterfaceByDeviceId.do")
	@ResponseBody
	public String listInterfaceByDeviceId(@RequestParam(value = "deviceId") Long deviceId, Integer pageIndex,
			Integer pageSize) {
		Map<String, Object> map = interfaceService.listByDeviceId(deviceId, pageIndex, pageSize);
		return toJSON(map);
	}

	@RequestMapping(value = "listParamByInterfaceId.do")
	@ResponseBody
	public String listParamByInterfaceId(@RequestParam(value = "interfaceId") Integer interfaceId, Integer pageIndex,
			Integer pageSize) {
		Map<String, Object> map = paramaterService.listByInterfaceId(interfaceId, pageIndex, pageSize);
		return toJSON(map);
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
				LOGGER.debug("序列化Announcement对象时出错", e);
			}
		}
		return result;
	}

	@RequestMapping(value = "invokeInterface.do", method = RequestMethod.POST)
	@ResponseBody
	public String invokeInterface(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		Map<String,Object> paramater=new HashMap<String,Object>(map.size());
		String url=null;
		String method = null;
		for(Iterator<Entry<String, String[]>> it=map.entrySet().iterator();it.hasNext();){
			Entry<String, String[]> entry=it.next();
			if(entry.getKey().equals("interfaceId")){
				
				continue;
			}
			if(entry.getKey().equals("interfaceUrl")){
				url=entry.getValue()[0];
				continue;
			}
			if(entry.getKey().equals("method")){
				method=entry.getValue()[0];
				continue;
			}
			paramater.put(entry.getKey(), entry.getValue()[0]);
		}
		
		String result = null;
		if (method.equals("GET")) {
			result = httpService.doGet(url, paramater);
		}
		if (method.equals("POST")){
			result = httpService.doPostSSL(url, paramater);
		}
		return result;
	}
}
