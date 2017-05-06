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

	@RequestMapping(value = "/updateDevice.do", method = RequestMethod.POST)
	public ModelAndView updateDevice(@ModelAttribute(value = "device") @Valid Device device, BindingResult result,
			@RequestParam(value = "img") MultipartFile img, @RequestParam(value = "model") MultipartFile modelFile,
			HttpServletRequest request, Model model, @RequestParam(value = "pageIndex") Integer pageIndex) {
		ModelAndView modelAndView = new ModelAndView(ERROR_PAGE);
		modelAndView.addObject("pageIndex", pageIndex);
		Device deviveTemp = deviceService.get(device.getDeviceId());
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("参数异常：result.hasErrors." + result);
			}
			modelAndView.addObject("status", "输入的参数有误");
			modelAndView.addObject("device", deviveTemp);
			modelAndView.setViewName("functionList/addFunctionToDevice");
			return modelAndView;
		}
		List<Device> temp = deviceService.getByName(device.getName());
		if ((device.getName().equals(deviveTemp.getName()) == false) && temp.size() > 0) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("该设备已存在." + result);
			}
			modelAndView.addObject("status", "该设备已存在.");
			modelAndView.addObject("device", deviveTemp);
			modelAndView.setViewName("deviceList/editDevice");
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
				modelAndView.addObject("device", deviveTemp);
				modelAndView.setViewName("deviceList/editDevice");
				return modelAndView;
			}
			fileService.saveFile(request, IMG_DIR, img);
			// 保存图片对象
			String imgPath = fileService.getFilePath(request, IMG_DIR, img);
			device.setImgPath(imgPath);
		} else {
			device.setImgPath(deviveTemp.getImgPath());
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
				modelAndView.addObject("device", deviveTemp);
				modelAndView.setViewName("deviceList/editDevice");
				return modelAndView;
			}
			fileService.saveFile(request, MODEL_DIR, modelFile);
			// 保存模型对象
			String filePath = fileService.getFilePath(request, MODEL_DIR, modelFile);
			System.out.println("model path:" + filePath);
			device.setModelPath(filePath);
		} else {
			device.setModelPath(deviveTemp.getModelPath());
		}
		deviceService.saveOrUpdate(device);
		modelAndView.addObject("status", "更新成功");
		deviveTemp = deviceService.get(device.getDeviceId());
		modelAndView.addObject("device", device);
		modelAndView.setViewName("deviceList/editDevice");
		return modelAndView;
	}

	@RequestMapping(value = "removeDevice.do", method = RequestMethod.GET)
	public String removeDevice(@RequestParam(value = "deviceId") Long deviceId,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize) {
		Device device = deviceService.get(deviceId);
		deviceService.remove(device);
		return "forward:/listDevice.do";
	}

	@RequestMapping(value = "saveInterface.do", method = RequestMethod.POST)
	public ModelAndView saveInterface(@ModelAttribute @Valid Interface face, BindingResult result, Model model,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize,
			@RequestParam(value = "backPageIndex") Integer backPageIndex) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("saveInterface error:" + result.getFieldError().toString());
			}
			Device device=deviceService.get(face.getDeviceId());
			modelAndView.setViewName("functionList/addFunctionToDevice");
			modelAndView.addObject("status", "参数错误");
			modelAndView.addObject("device", device);
			modelAndView.addObject("data", face);
			modelAndView.addObject("pageIndex", pageIndex);
			modelAndView.addObject("pageSize", pageSize);
			modelAndView.addObject("backPageIndex", backPageIndex);
			return modelAndView;
		}
		Device temp = deviceService.get(face.getDeviceId());
		if (temp == null) {
			modelAndView.setViewName("functionList/addFunctionToDevice");
			modelAndView.addObject("status", "设备不存在");
			modelAndView.addObject("device", temp);
			modelAndView.addObject("data", face);
			modelAndView.addObject("pageIndex", pageIndex);
			modelAndView.addObject("pageSize", pageSize);
			modelAndView.addObject("backPageIndex", backPageIndex);
			return modelAndView;
		}
		List<Interface> interfaceTemp = interfaceService.listByInterfaceName(temp.getDeviceId(),
				face.getInterfaceName());
		// 插入时判断重复
		if (interfaceTemp.size() > 0) {
			modelAndView.setViewName("functionList/addFunctionToDevice");
			modelAndView.addObject("status", "接口名重复");
			modelAndView.addObject("device", temp);
			modelAndView.addObject("data", face);
			modelAndView.addObject("pageIndex", pageIndex);
			modelAndView.addObject("pageSize", pageSize);
			modelAndView.addObject("backPageIndex", backPageIndex);
			return modelAndView;
		}
		String url = face.getInterfaceUrl();
		if (!url.startsWith("http://")) {
			face.setInterfaceUrl("http://" + url);
		}
		interfaceService.saveOrUpdate(face);
		Device device = deviceService.get(face.getDeviceId());
		modelAndView.setViewName("functionList/addFunctionToDevice");
		modelAndView.addObject("status", "新增成功");
		modelAndView.addObject("device", device);
		modelAndView.addObject("data", face);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("backPageIndex", backPageIndex);
		return modelAndView;
	}

	@RequestMapping(value = "updateInterface.do", method = RequestMethod.POST)
	public ModelAndView updateInterface(@ModelAttribute @Valid Interface face, BindingResult result, Model model,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize,
			@RequestParam(value = "backPageIndex") Integer backPageIndex) {
		ModelAndView modelAndView = new ModelAndView("dormitory");
		Device oldDevice = deviceService.get(face.getDeviceId());
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("updateInterface error:" + result.getFieldError().toString());
			}
			modelAndView.setViewName("functionList/editDevicefunction");
			modelAndView.addObject("status", "参数错误");
			modelAndView.addObject("device", oldDevice);
			modelAndView.addObject("data", face);
			modelAndView.addObject("pageIndex", pageIndex);
			modelAndView.addObject("pageSize", pageSize);
			modelAndView.addObject("backPageIndex", backPageIndex);
		}
		
		if (oldDevice == null) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("updateInterface error:" + result.getFieldError().toString());
			}
			modelAndView.setViewName("functionList/editDevicefunction");
			modelAndView.addObject("status", "设备不存在");
			modelAndView.addObject("device", oldDevice);
			modelAndView.addObject("data", face);
			modelAndView.addObject("pageIndex", pageIndex);
			modelAndView.addObject("pageSize", pageSize);
			modelAndView.addObject("backPageIndex", backPageIndex);
			return modelAndView;
		}
		List<Interface> interfaceTemp = interfaceService.listByInterfaceName(oldDevice.getDeviceId(),
				face.getInterfaceName());
		Interface oldFace = interfaceService.get(face.getInterfaceId());
		// 更新时判断重复
		if ((oldFace.getInterfaceName().equals(face.getInterfaceName()) == false) && interfaceTemp.size() > 0) {
			modelAndView.setViewName("functionList/editDevicefunction");
			modelAndView.addObject("status", "接口名重复");
			modelAndView.addObject("device", oldDevice);
			modelAndView.addObject("data", face);
			modelAndView.addObject("pageIndex", pageIndex);
			modelAndView.addObject("pageSize", pageSize);
			modelAndView.addObject("backPageIndex", backPageIndex);
			return modelAndView;
		}
		String url = face.getInterfaceUrl();
		if (!url.startsWith("http://")) {
			face.setInterfaceUrl("http://" + url);
		}
		interfaceService.saveOrUpdate(face);
		
		modelAndView.setViewName("functionList/editDevicefunction");
		modelAndView.addObject("status", "修改成功");
		modelAndView.addObject("device", oldDevice);
		modelAndView.addObject("data", face);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("backPageIndex", backPageIndex);
		return modelAndView;
	}

	@RequestMapping(value = "removeInterface.do", method = RequestMethod.GET)
	public String removeInterface(@RequestParam(value = "interfaceId") Integer interfaceId,
			@RequestParam(value = "deviceId") Long deviceId, @RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize,
			@RequestParam(value = "hiddenPageIndex") Integer hiddenPageIndex) {
		Interface face = interfaceService.get(interfaceId);
		interfaceService.remove(face);
		return "forward:/listInterfaceByDeviceId.do?deviceId=" + deviceId + "&pageIndex=" + pageIndex + "&pageSize="
				+ pageSize + "&hiddenPageIndex=" + hiddenPageIndex;
	}

	@RequestMapping(value = "saveParamater.do", method = RequestMethod.POST)
	public ModelAndView saveParamater(@ModelAttribute(value = "paramater") @Valid Paramater paramater,
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
		// 插入时判断重复

		if (list.size() > 0) {
			System.out.println("list!=null");
			modelAndView.setViewName(ERROR_PAGE);
			model.addAttribute("status", "参数名重复");
			return modelAndView;
		}

		paramaterService.saveOrUpdate(paramater);
		modelAndView.setViewName("");
		modelAndView.addObject("status", "新增成功");
		return modelAndView;
	}

	@RequestMapping(value = "updateParamater.do", method = RequestMethod.POST)
	public ModelAndView updateParamater(@ModelAttribute(value = "paramater") @Valid Paramater paramater,
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
		Paramater oldParam = paramaterService.get(paramater.getInterfaceId());
		// 更新时判断重复
		if ((oldParam.getParamaterName().equals(paramater.getParamaterName()) == false) && list.size() > 0) {
			modelAndView.setViewName(ERROR_PAGE);
			model.addAttribute("status", "参数名重复");
			return modelAndView;
		}
		paramaterService.saveOrUpdate(paramater);
		modelAndView.setViewName("");
		modelAndView.addObject("status", "修改成功");
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

	@RequestMapping(value = "editDevicePage.do", method = RequestMethod.GET)
	public ModelAndView forwardEditDevicePage(@RequestParam(value = "deviceId") Long deviceId,
			@RequestParam(value = "pageIndex") Integer pageIndex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("deviceList/editDevice");
		Device temp = deviceService.get(deviceId);
		modelAndView.addObject("device", temp);
		modelAndView.addObject("pageIndex", pageIndex);
		return modelAndView;
	}

}
