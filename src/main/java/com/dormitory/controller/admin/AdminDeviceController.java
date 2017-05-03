package com.dormitory.controller.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.DeviceController;
import com.dormitory.entity.Device;
import com.dormitory.entity.Interface;
import com.dormitory.entity.Paramater;
import com.dormitory.service.FileService;

@Controller("adminDeviceController")
@RequestMapping(value = "/admin")
public class AdminDeviceController extends DeviceController {
	@Resource
	private FileService fileService;

	@RequestMapping(value = "/saveOrUpdateDevice.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateDevice(@ModelAttribute(value = "device") @Valid Device device, BindingResult result,
			@RequestParam(value = "img") MultipartFile img, @RequestParam(value = "model") MultipartFile modelFile,
			HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("参数异常：result.hasErrors." + result);
			}
			modelAndView.addObject("status", "输入的参数有误");
			modelAndView.setViewName("deviceList/addDevice");
			return modelAndView;
		}
		device.setDescription(device.getDescription().trim());
		device.setName(device.getName().trim());
		device.setType(device.getType().trim());
		List<Device> temp = deviceService.getByName(device.getName());
		if (temp.size() > 0) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("该设备已存在." + result);
			}
			modelAndView.addObject("status", "该设备已存在.");
			modelAndView.setViewName("deviceList/addDevice");
			return modelAndView;
		}

		if (img != null && img.getSize() > 0) {
			System.out.println("file:" + img.getOriginalFilename());
			String imgName = img.getOriginalFilename().toLowerCase();
			System.out.println("img name:" + imgName + " ends with jpg:" + imgName.endsWith(".jpg"));

			if (!(imgName.endsWith(".jpg"))) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("img文件类型异常：");
				}
				modelAndView.addObject("status", "img文件类型错误");
				modelAndView.setViewName("deviceList/addDevice");
				return modelAndView;
			}
			fileService.saveFile(request, IMG_DIR, img);
			// 保存图片对象
			String imgPath = fileService.getFilePath(request, IMG_DIR, img);
			device.setImgPath(imgPath);
		}
		if (modelFile != null && modelFile.getSize() > 0) {
			System.out.println("file:" + modelFile.getOriginalFilename());
			String modelName = modelFile.getOriginalFilename().toLowerCase();
			System.out.println("model name:" + modelName + " ends with obj or dae:"
					+ (modelName.endsWith(".obj") || modelName.endsWith(".dae")));

			if (!(modelName.endsWith(".obj") || modelName.endsWith(".dae"))) {
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("model文件类型异常：");
				}
				modelAndView.addObject("status", "model文件类型错误");
				modelAndView.setViewName("deviceList/addDevice");
				return modelAndView;
			}
			fileService.saveFile(request, MODEL_DIR, modelFile);
			// 保存模型对象
			String filePath = fileService.getFilePath(request, MODEL_DIR, modelFile);
			System.out.println("model path:" + filePath);
			device.setModelPath(filePath);
		}

		deviceService.saveOrUpdate(device);
		modelAndView.addObject("status", "上传设备成功");
		modelAndView.setViewName("deviceList/addDevice");
		return modelAndView;
	}

	@RequestMapping(value = "removeDevice.do", method = RequestMethod.GET)
	public ModelAndView removeDevice(@RequestParam(value = "deviceId") Long deviceId) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		Device device = deviceService.get(deviceId);
		deviceService.remove(device);
		return modelAndView;
	}

	@RequestMapping(value = "saveOrUpdateInterface.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateInterface(@ModelAttribute @Valid Interface face, BindingResult result,
			Model model) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		Device temp = deviceService.get(face.getDeviceId());
		if (temp == null) {
			modelAndView.setViewName(ERROR_PAGE);
			model.addAttribute("status", "设备不存在");
			return modelAndView;
		}
		List<Interface> interfaceTemp = interfaceService.listByInterfaceName(temp.getDeviceId(),
				face.getInterfaceName());
		if (interfaceTemp.size() > 0) {
			modelAndView.setViewName(ERROR_PAGE);
			model.addAttribute("status", "接口名重复");
			return modelAndView;
		}
		String url = face.getInterfaceUrl();
		if (!url.startsWith("http://")) {
			face.setInterfaceUrl("http://" + url);
		}
		interfaceService.saveOrUpdate(face);
		modelAndView.setViewName("");
		return modelAndView;
	}

	@RequestMapping(value = "removeInterface.do", method = RequestMethod.GET)
	public ModelAndView removeInterface(@RequestParam(value = "interfaceId") Integer interfaceId) {
		ModelAndView modelAndView = new ModelAndView("");
		Interface face = interfaceService.get(interfaceId);
		interfaceService.remove(face);
		return modelAndView;
	}

	@RequestMapping(value = "saveOrUpdateParamater.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateParamater(@ModelAttribute(value = "paramater") @Valid Paramater paramater,
			BindingResult result, Model model) {
		ModelAndView modelAndView = new ModelAndView("");
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		Interface temp = interfaceService.get(paramater.getInterfaceId());
		if (temp == null) {
			modelAndView.setViewName(ERROR_PAGE);
			model.addAttribute("status", "接口不存在");
			return modelAndView;
		}
		List<Paramater> list = paramaterService.listByParamName(temp.getInterfaceId(), paramater.getParamaterName());
		if (list.size() > 0) {
			System.out.println("list!=null");
			modelAndView.setViewName(ERROR_PAGE);
			model.addAttribute("status", "参数名重复");
			return modelAndView;
		}
		paramaterService.saveOrUpdate(paramater);
		modelAndView.setViewName("");
		return modelAndView;
	}

	@RequestMapping(value = "removeParamater.do", method = RequestMethod.POST)
	public ModelAndView removeParamater(@RequestParam(value = "paramaterId") Integer paramaterId) {
		ModelAndView modelAndView = new ModelAndView("");
		Paramater paramater = paramaterService.get(paramaterId);
		paramaterService.remove(paramater);
		return modelAndView;
	}

	@RequestMapping(value = "addDevicePage.do", method = RequestMethod.GET)
	public ModelAndView forwardAddDevicePage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deviceList/addDevice");
		return modelAndView;
	}
}
