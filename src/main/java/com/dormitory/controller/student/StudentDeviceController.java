package com.dormitory.controller.student;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
