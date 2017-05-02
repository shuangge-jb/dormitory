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
import com.dormitory.entity.Interface;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.InterfaceService;
import com.dormitory.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller("studentDeviceController")
@RequestMapping(value = "/student")
public class StudentDeviceController extends DeviceController {
	@Resource
	private DormitoryService dormitoryService;
	@Resource
	private StudentService studentService;
	@Resource
	private InterfaceService interfaceService;

	@RequestMapping(value = "invokeInterface.do", method = RequestMethod.POST)
	@ResponseBody
	public String invokeInterface(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		Map<String, Object> paramater = new HashMap<String, Object>(map.size());
		String interfaceId=request.getParameter("interfaceId");
		Interface face = interfaceService.get(Integer.valueOf(interfaceId));
		String url=face.getInterfaceUrl();
		String method = face.getMethod().toUpperCase();
		for (Iterator<Entry<String, String[]>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, String[]> entry = it.next();
			if (entry.getKey().equals("interfaceId")) {

				continue;
			}
//			if (entry.getKey().equals("interfaceUrl")) {
//				url = entry.getValue()[0];
//				continue;
//			}
//			if (entry.getKey().equals("method")) {
//				method = entry.getValue()[0];
//				continue;
//			}
			System.out.println("key:"+entry.getKey()+" value:"+ entry.getValue()[0]);
			paramater.put(entry.getKey(), entry.getValue()[0]);
		}

		String result = null;
		if (method.equals("POST")) {
			result = httpService.doPostSSL(url, paramater);
		}
		if (method.equals("GET")) {
			result = httpService.doGet(url, paramater);
		}
		
		System.out.println("result:"+result);
		return result;
	}
}
