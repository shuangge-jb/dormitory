package com.dormitory.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.Announcement;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.service.AnnouncementService;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
//@SessionAttributes(value={"studentId","dormitoryId"})
public class AnnouncementController {
	@Resource
	protected AnnouncementService announcementService;
	@Resource
	protected StudentService studentService;
	@Resource
	protected DormitoryService dormitoryService;
	protected static final String IMG_DIR = "/images/";
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final String ERROR_INPUT = "输入的参数有误";
	protected static final String ERROR_PAGE_SIZE = "页大小不能为0";
	protected static final Logger LOGGER = LoggerFactory.getLogger(AnnouncementController.class);

	/**
	 * 查看所在楼的公告
	 * 
	 * @param studentId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "listMyDormitoryAnnouncement.do")
	public ModelAndView listAnnouncement(@RequestParam(value = "studentId") Long studentId,
			@RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		if(studentId==null){
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", "学号为空");
			return modelAndView;
		}else{
		Student student = studentService.get(studentId);
		Dormitory dormitory = dormitoryService.get(student.getDormitoryId());
		Integer buildingId=dormitory.getBuildingId();
		List<Announcement> list = announcementService.listByBuildingId(buildingId, pageIndex, pageSize);
		Integer total = announcementService.getSizeByBuildingId(buildingId);
		Integer totalPage = getTotalPages(total, pageSize);
		modelAndView.addObject("announcementDataList", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("result", list != null);
		//modelAndView.addObject("studentId", studentId);
		}
		modelAndView.setViewName("studentAnnoucment/announcementPage");
		return modelAndView;
	}

	@RequestMapping(value = "/listAnnouncementLimit.do")
	@ResponseBody
	public String listAnnouncementLimit(@RequestParam(value = "n") Integer n) {
		List<Announcement> list = announcementService.listLimit(n);
		return toJSON(list);
	}

	@RequestMapping(value = "getAnnouncement.do")
	public ModelAndView getAnnouncement(@RequestParam("announcementId") Integer announcementId) {
		ModelAndView modelAndView = new ModelAndView();
		Announcement announcement = announcementService.get(announcementId);
		modelAndView.addObject("announcement", announcement);
		modelAndView.setViewName("studentAnnoucment/announcementDetailPage");
		return modelAndView;
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

	protected int getTotalPages(Integer count, Integer pageSize) {
		if (pageSize == null) {
			pageSize = 10;
		}
		int totalPages = 0;
		totalPages = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
		return totalPages;
	}

	/**
	 * 查看所有公告
	 * 
	 * @return
	 */
	@RequestMapping(value = "forwardAnnouncementPage.do")
	public ModelAndView forwardAnnouncementPage(@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("studentAnnoucment/announcementPage");
		if(pageIndex<=0||pageSize<=0){
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", "分页参数错误");
			return modelAndView;
		}
		List<Announcement> list = announcementService.list(pageIndex, pageSize);
		Integer total = announcementService.getSize();
		Integer totalPages = getTotalPages(total, pageSize);
		modelAndView.addObject("data", list);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPages);
		return modelAndView;
	}
	@RequestMapping(value = "forwardAnnouncementDetailPage.do")
	public ModelAndView forwardAnnouncementDetailPage(@RequestParam(value = "announcementId")Integer announcementId){
		ModelAndView modelAndView = new ModelAndView("studentAnnoucment/announcementDetailPage");
		if(announcementId==null){
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", "无效的公告id");
			return modelAndView;
		}
		Announcement announcement=announcementService.get(announcementId);
		modelAndView.addObject("data", announcement);
		return modelAndView;
	}
}
