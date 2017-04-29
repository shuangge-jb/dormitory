package com.dormitory.controller.admin;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.AbstractDeviceController;
import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.Device;
import com.dormitory.service.FileService;

@Controller
@RequestMapping(value="/admin")
public class DeviceController extends AbstractDeviceController{
	@Resource
	private FileService fileService;
	@RequestMapping(value = "/saveDevice.do", method = RequestMethod.POST)
	public ModelAndView saveDevice(@ModelAttribute(value = "device") @Valid Device device, BindingResult result,
			@RequestParam(value = "file") MultipartFile file, HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("参数异常：result.hasErrors." + result);
			}
			return modelAndView;
		}
		System.out.println("file:" + file);
		if (file == null || file.isEmpty()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("文件为空：");
			}
			return modelAndView;
		}
		System.out.println("file name:" + file.getOriginalFilename() + " ends with obj:"
				+ file.getOriginalFilename().endsWith(".obj"));
		if (!(file.getOriginalFilename().toLowerCase().endsWith(".obj")
				|| file.getOriginalFilename().toLowerCase().endsWith(".dae"))) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("file参数异常：");
			}
			return modelAndView;
		}
		//model.addAttribute("imgUrl", dirUrl+modelNameWithTimestamp);
		// 保存上传的模型
		fileService.saveFile(request,MODEL_DIR,file);
		// 保存物品对象
		String filePath=fileService.getFilePath(request, MODEL_DIR, file);
		System.out.println("model path:"+filePath);
		device.setPath(filePath);
		deviceService.saveOrUpdate(device);
		modelAndView.setViewName("/student");
		return modelAndView;
	}

}
