package com.dormitory.controller.master;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.AnnouncementController;
import com.dormitory.dto.master.MasterDTO;
import com.dormitory.entity.Announcement;
import com.dormitory.entity.Master;
import com.dormitory.service.FileService;
import com.dormitory.service.MasterService;

@SessionAttributes("masterId")
@Controller
@RequestMapping(value = "/master")
public class MasterAnnouncementController extends AnnouncementController {
	@Resource
	private MasterService masterService;
	@Resource
	private FileService fileService;

	@RequestMapping(value = "/saveAnnouncement.do", method = RequestMethod.POST)
	public ModelAndView saveAnnouncement(@ModelAttribute(value = "announcement") @Valid Announcement announcement,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("masterList/addAnnouncement");
		if (result.hasErrors()) {
			modelAndView.addObject("status", "输入的信息有误，请检查");
			System.out.println("saveAnnouncement error:" + result.getFieldError());
			return modelAndView;
		}
		Master master = masterService.get(announcement.getAuthorId());
		announcement.setBuildingId(master.getBuildingId());
		System.out.println("announcement:" + announcement);
		announcementService.saveOrUpdate(announcement);
		modelAndView.addObject("status", "添加成功");
		return modelAndView;
	}

	@Deprecated
	@RequestMapping(value = "/updateAnnouncement.do", method = RequestMethod.POST)
	public ModelAndView updateAnnouncement(@ModelAttribute(value = "announcement") @Valid Announcement announcement,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}

		Master master = masterService.get(announcement.getAuthorId());
		announcement.setBuildingId(master.getBuildingId());

		System.out.println("announcement:" + announcement);
		announcementService.saveOrUpdate(announcement);
		// TODO
		modelAndView.setViewName("");
		modelAndView.addObject("status", OPERATE_SUCCESS);
		modelAndView.addObject("announcement", announcement);
		return modelAndView;
	}

	@RequestMapping(value = "/removeAnnouncement.do", method = RequestMethod.GET)
	public ModelAndView removeAnnouncement(@RequestParam(value = "announcementId") Integer announcementId,
			@RequestParam(value = "masterId") Integer masterId, @RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		
		Announcement announcement = announcementService.get(announcementId);
		announcementService.remove(announcement);
		
		ModelAndView modelAndView = new ModelAndView("forward:listAnnouncementByMasterId.do");
		modelAndView.addObject("masterId", masterId);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		return modelAndView;
	}

	@RequestMapping(value = "/forwardAddAnnouncement.do")
	public ModelAndView forwardAddAnnouncement() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("masterList/addAnnouncement");
		return modelAndView;
	}

	@RequestMapping(value = "listAnnouncementByMasterId.do")
	public ModelAndView listAnnouncementByMasterId(@RequestParam(value = "masterId") Integer masterId,
			@RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		Master master = masterService.get(masterId);
		Integer buildingId = master.getBuildingId();
		List<Announcement> list = announcementService.listByBuildingId(buildingId, pageIndex, pageSize);
		Integer total = announcementService.getSizeByBuildingId(buildingId);
		Integer totalPage = getTotalPages(total, pageSize);
		modelAndView.setViewName("masterList/listAnnoucement");
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("result", list != null);
		return modelAndView;
	}
	
	protected int getTotalPages(Integer count, Integer pageSize) {
		if (pageSize == null) {
			pageSize = 10;
		}
		int totalPages = 0;
		totalPages = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
		return totalPages;
	}
}
