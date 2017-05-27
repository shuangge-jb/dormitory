package com.dormitory.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.student.StudentController;
import com.dormitory.dto.master.LostFoundDTO;
import com.dormitory.entity.LostFound;
import com.dormitory.entity.Master;
import com.dormitory.service.FileService;
import com.dormitory.service.LostFoundService;
import com.dormitory.service.MasterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LostFoundController {
	@Resource
	protected LostFoundService lostFoundService;
	@Resource
	protected MasterService masterService;
	@Resource
	private FileService fileService;
	protected static final String IMG_DIR = "/images/";
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final String ERROR_INPUT = "输入的参数有误";
	protected static final Logger LOGGER = LoggerFactory.getLogger(LostFoundController.class);

	@RequestMapping(value = "listLostFound.do")
	public ModelAndView listLostFound(@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		List<LostFoundDTO> list = lostFoundService.list(pageIndex, pageSize);
		Integer total = lostFoundService.getSize();
		Integer totalPage = getTotalPages(total, pageSize);
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("result", list != null);
		modelAndView.setViewName("studentAnnoucment/lostFound");
		return modelAndView;
	}

	@RequestMapping(value = "saveLostFound.do", method = RequestMethod.POST)
	public ModelAndView saveLostFound(@ModelAttribute(value = "lostFound") @Valid LostFound lostFound,
			BindingResult result, @RequestParam(value = "img") MultipartFile img, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("masterList/addLostFound");
		System.out.println("saveLostFound");
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("saveLostFound error:" + result.getFieldError());
			}

			modelAndView.addObject("status", ERROR_INPUT);
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
				return modelAndView;
			}
			fileService.saveFile(request, IMG_DIR, img);
			// 保存图片对象
			String imgPath = fileService.getFilePath(request, IMG_DIR, img);
			lostFound.setImgPath(imgPath);
		}
		System.out.println("lostFound:" + lostFound);
		lostFoundService.saveOrUpdate(lostFound);
		modelAndView.addObject("status", "新增成功");
		modelAndView.addObject("data", lostFound);
		return modelAndView;
	}

	@RequestMapping(value = "updateLostFound.do", method = RequestMethod.POST)
	public ModelAndView updateLostFound(@ModelAttribute(value = "lostFound") @Valid LostFound lostFound,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("masterList/addLostFound");
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("saveLostFound error:" + result.getFieldError());
			}
			modelAndView.addObject("status", ERROR_INPUT);
			return modelAndView;
		}

		lostFoundService.saveOrUpdate(lostFound);
		modelAndView.addObject("status", "修改成功");
		modelAndView.addObject("data", lostFound);
		return modelAndView;
	}

	@RequestMapping(value = "removeLostFound.do", method = RequestMethod.GET)
	public ModelAndView removeLostFound(@RequestParam(value = "lostFoundId") Integer lostFoundId,
			@RequestParam(value = "masterId") Integer masterId, @RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		lostFoundService.remove(lostFoundId);
		ModelAndView modelAndView = new ModelAndView("forward:/master/listLostFoundByMasterId.do?");
		modelAndView.addObject("masterId", masterId);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		return modelAndView;
	}

	@RequestMapping(value = "getLostFound.do")
	@ResponseBody
	public String getLostFound(@RequestParam(value = "lostFoundId") Integer lostFoundId) {
		LostFound lost = lostFoundService.get(lostFoundId);
		return toJSON(lost);
	}

	@RequestMapping(value = "changeState.do", method = RequestMethod.POST)
	@ResponseBody
	public String changeState(@RequestParam(value = "lostFoundId") Integer lostFoundId) {
		lostFoundService.changeState(lostFoundId);
		return "{\"data\":\"已认领\"}";
	}

	protected int getTotalPages(Integer count, Integer pageSize) {
		if (pageSize == null) {
			pageSize = 10;
		}
		int totalPages = 0;
		totalPages = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
		return totalPages;
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
				LOGGER.debug("序列化LostFound对象时出错", e);
			}
		}
		return result;
	}

	@RequestMapping(value = "listLostFoundLimit.do")
	@ResponseBody
	public String listLostFoundLimit(@RequestParam(value = "n") Integer n) {
		List<LostFound> list = lostFoundService.listLimit(n);
		return toJSON(list);
	}
}
