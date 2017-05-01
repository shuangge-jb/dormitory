package com.dormitory.controller.admin;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.DeviceController;
import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.Device;
import com.dormitory.entity.Interface;
import com.dormitory.entity.Paramater;
import com.dormitory.service.FileService;
import com.dormitory.service.InterfaceService;
import com.dormitory.service.ParamaterService;

@Controller("adminDeviceController")
@RequestMapping(value = "/admin")
public class AdminDeviceController extends DeviceController {
	@Resource
	private FileService fileService;

	@RequestMapping(value = "/saveOrUpdateDevice.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateDevice(@ModelAttribute(value = "device") @Valid Device device, BindingResult result,
			@RequestParam(value = "file") MultipartFile[] file, HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("参数异常：result.hasErrors." + result);
			}
			return modelAndView;
		}
		for (int i = 0; i < file.length; i++) {
			System.out.println("file:" + file[i]);

			System.out.println("file name:" + file[i].getOriginalFilename() + " ends with obj:"
					+ file[i].getOriginalFilename().endsWith(".obj"));
			if (!(file[i].getOriginalFilename().toLowerCase().endsWith(".obj")
					|| file[i].getOriginalFilename().toLowerCase().endsWith(".dae"))) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("file参数异常：");
				}
				return modelAndView;
			}
			if (file[i].getOriginalFilename().toLowerCase().endsWith(".jpg")) {
				fileService.saveFile(request, IMG_DIR, file[i]);
				//保存图片对象
				String imgPath = fileService.getFilePath(request, IMG_DIR, file[i]);
				device.setImgPath(imgPath);
			}
			if (file[i].getOriginalFilename().toLowerCase().endsWith(".obj")
					|| file[i].getOriginalFilename().toLowerCase().endsWith(".dae")) {
				fileService.saveFile(request, MODEL_DIR, file[i]);
				// 保存模型对象
				String filePath = fileService.getFilePath(request, MODEL_DIR, file[i]);
				System.out.println("model path:" + filePath);
				device.setModelPath(filePath);
			}
			deviceService.saveOrUpdate(device);
		}
		modelAndView.setViewName("/student");
		return modelAndView;
	}

	@RequestMapping(value = "removeDevice.do", method = RequestMethod.POST)
	public ModelAndView removeDevice(@RequestParam(value = "deviceId") Long deviceId) {
		ModelAndView modelAndView = new ModelAndView();
		Device device = deviceService.get(deviceId);
		deviceService.remove(device);
		return modelAndView;
	}

	@RequestMapping(value = "saveOrUpdateInterface.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateInterface(@RequestParam(value = "deviceId") Long deviceId,
			@ModelAttribute(value = "inerface") @Valid Interface face, BindingResult result, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		Device temp = deviceService.get(deviceId);
		if (temp == null) {
			modelAndView.setViewName(ERROR_PAGE);
			model.addAttribute("status", "设备不存在");
			return modelAndView;
		}
		interfaceService.saveOrUpdate(face);
		modelAndView.setViewName("");
		return modelAndView;
	}

	@RequestMapping(value = "removeInterface.do", method = RequestMethod.POST)
	public ModelAndView removeInterface(@RequestParam(value = "interfaceId") Integer interfaceId) {
		ModelAndView modelAndView = new ModelAndView();
		Interface face = interfaceService.get(interfaceId);
		interfaceService.remove(face);
		return modelAndView;
	}

	@RequestMapping(value = "saveOrUpdateParamater.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateParamater(@RequestParam(value = "interfaceId") Integer interfaceId,
			@ModelAttribute(value = "paramater") @Valid Paramater paramater, BindingResult result, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		Paramater temp = paramaterService.get(interfaceId);
		if (temp == null) {
			modelAndView.setViewName(ERROR_PAGE);
			model.addAttribute("status", "接口不存在");
			return modelAndView;
		}
		paramaterService.saveOrUpdate(paramater);
		modelAndView.setViewName("");
		return modelAndView;
	}

	@RequestMapping(value = "removeParamater.do", method = RequestMethod.POST)
	public ModelAndView removeParamater(@RequestParam(value = "paramaterId") Integer paramaterId) {
		ModelAndView modelAndView = new ModelAndView();
		Paramater paramater = paramaterService.get(paramaterId);
		paramaterService.remove(paramater);
		return modelAndView;
	}
}
