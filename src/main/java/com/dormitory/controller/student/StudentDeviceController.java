package com.dormitory.controller.student;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.DeviceController;
import com.dormitory.dto.ParamaterDTO;
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
	public ModelAndView invokeInterface(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		Map<String, Object> paramater = new HashMap<String, Object>(map.size());
		String interfaceId = request.getParameter("interfaceId");
		Interface function=interfaceService.get(Integer.valueOf(interfaceId));
		String source=function.getSource();
		Interface face = interfaceService.get(Integer.valueOf(interfaceId));
		String url = face.getInterfaceUrl();
		String method = face.getMethod().toUpperCase();
		for (Iterator<Entry<String, String[]>> it = map.entrySet().iterator(); it.hasNext();) {
			Entry<String, String[]> entry = it.next();
			if (entry.getKey().equals("interfaceId")) {

				continue;
			}
			// if (entry.getKey().equals("interfaceUrl")) {
			// url = entry.getValue()[0];
			// continue;
			// }
			// if (entry.getKey().equals("method")) {
			// method = entry.getValue()[0];
			// continue;
			// }
			System.out.println("key:" + entry.getKey() + " value:" + entry.getValue()[0]);
			paramater.put(entry.getKey(), entry.getValue()[0]);
		}

		String result = null;
		if (method.equals("POST")) {
			result = httpService.doPostSSL(url, paramater);
		}
		if (method.equals("GET")) {
			result = httpService.doGet(url, paramater);
		}

		System.out.println("result:" + result);
		ModelAndView modelAndView=new ModelAndView("studentDevices/showData");
		modelAndView.addObject("data", result);
		modelAndView.addObject("functionId", interfaceId);
		modelAndView.addObject("source", source);
		return modelAndView;
	}

	@RequestMapping(value = "listUserDevice.do")
	public ModelAndView listUserDevice(@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		if (pageIndex == null || pageIndex <= 0 || pageSize == null || pageSize == 0) {
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", ERROR_PAGE_SIZE);
			return modelAndView;
		}
		List<Device> list = deviceService.list(pageIndex, pageSize);
		Long total = deviceService.getSize();

		Long totalPage = getTotalPages(total, pageSize);
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("totalCount", total);
		modelAndView.setViewName("studentDevices/myDormitoryDevice");
		modelAndView.addObject("result", list != null);
		return modelAndView;
	}


	/**
	 * 模糊搜索出该设备的功能
	 * 
	 * @param deviceId
	 * @param keyword
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "listFunctionByDeviceIdLike.do")
	public ModelAndView listFunctionByDeviceIdLike(@RequestParam(value = "deviceId") Long deviceId,
			@RequestParam(value = "keyword") String keyword, @RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("");
		String newKeyword=keyword.trim();
		List<Interface> list = interfaceService.listLike(newKeyword, deviceId, pageIndex, pageSize);
		Device device = deviceService.get(deviceId);
		Integer total = interfaceService.getSizeLike(newKeyword, deviceId);
		Integer totalPage = getTotalPages(total, pageSize);
		modelAndView.setViewName("studentDevices/deviceFunction");
		modelAndView.addObject("device", device);
		modelAndView.addObject("data", list);
		modelAndView.addObject("keyword", keyword);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		return modelAndView;
	}

	@RequestMapping(value = "listUserInterfaceByDeviceId.do")
	public ModelAndView listInterfaceByDeviceId(@RequestParam(value = "deviceId") Long deviceId,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		if (pageIndex == null || pageIndex <= 0 || pageSize == null || pageSize == 0) {
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", ERROR_PAGE_SIZE);
			return modelAndView;
		}
		List<Interface> list = interfaceService.listByDeviceId(deviceId, pageIndex, pageSize);
		System.out.println("device list:" + toJSON(list));
		Integer total = interfaceService.getSizeByDeviceId(deviceId);
		Device device = deviceService.get(deviceId);
		Integer totalPage = getTotalPages(total, pageSize);
		modelAndView.setViewName("studentDevices/deviceFunction");
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("result", list != null);
		modelAndView.addObject("device", device);
		return modelAndView;
	}

	@RequestMapping(value = "forwardParam.do")
	public ModelAndView forwardParam(@RequestParam(value = "interfaceId") Integer interfaceId) {
		ModelAndView modelAndView = new ModelAndView();
		Interface face = interfaceService.get(interfaceId);
		modelAndView.addObject("face", face);
		modelAndView.addObject("interfaceId", interfaceId);
		modelAndView.setViewName("studentDevices/parameterDevice");
		return modelAndView;

	}
	@RequestMapping(value = "virtualDormitory.do")
	public ModelAndView forwardVirtualDormitory() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("studentAnnoucment/myDormitory");
		return modelAndView;

	}

	@RequestMapping(value = "listUserParamByInterfaceId.do")
	@ResponseBody
	public String listParamByInterfaceIdUser(@RequestParam(value = "interfaceId") Integer interfaceId) {
		List<ParamaterDTO> list = paramaterService.listByInterfaceIdAll(interfaceId);
		//TODO
		//ModelAndView modelAndView = new ModelAndView("studentDevices/");
		String result=toJSON(list);
		//modelAndView.addObject("data", result);
		return result;
	}
}
