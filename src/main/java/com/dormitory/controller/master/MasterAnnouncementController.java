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

	@RequestMapping(value = "/saveOrUpdateAnnouncement.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateAnnouncement(
			@ModelAttribute(value = "announcement") @Valid Announcement announcement, BindingResult result,
			@RequestParam(value = "img") MultipartFile img, HttpServletRequest request, Model model) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		if (img != null && img.getSize() > 0) {
			if (!img.getOriginalFilename().toLowerCase().endsWith(".jpg")) {
				modelAndView.setViewName(ERROR_PAGE);
				modelAndView.addObject("status", "文件格式错误");
				return modelAndView;
			}
			fileService.saveFile(request, IMG_DIR, img);
			String imgPath = fileService.getFilePath(request, IMG_DIR, img);
			announcement.setImgPath(imgPath);
		}
		Master master = masterService.get(announcement.getAuthorId());
		announcement.setBuildingId(master.getBuildingId());
		System.out.println("announcement:"+announcement);
		announcementService.saveOrUpdate(announcement);
		// TODO
		modelAndView.setViewName("announcement");
		modelAndView.addObject("status", OPERATE_SUCCESS);
		return modelAndView;
	}

	@RequestMapping(value = "/removeAnnouncement.do", method = RequestMethod.POST)
	public ModelAndView removeAnnouncement(@RequestParam(value="announcementId")Integer announcementId) {
		ModelAndView modelAndView = new ModelAndView("homePage");
		Announcement announcement=announcementService.get(announcementId);
		announcementService.remove(announcement);
		// TODO
		modelAndView.setViewName("announcement");
		modelAndView.addObject("status", REMOVE_SUCCESS);
		return modelAndView;
	}

	@RequestMapping(value = "listAnnouncementByMasterId.do")
	@ResponseBody
	public String listAnnouncementByMasterId(@RequestParam(value = "masterId") Integer masterId,
			@RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize) {
		Master master = masterService.get(masterId);
		Integer buildingId = master.getBuildingId();
		List<Announcement> list = announcementService.listByBuildingId(buildingId, pageIndex, pageSize);
		Integer total = announcementService.getSizeByBuildingId(buildingId);
		Integer totalPage = getTotalPages(total, pageSize);
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("data", list);
		map.put("total", total);
		map.put("totalPages", totalPage);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		map.put("result", list != null);
		return toJSON(map);
	}
}
