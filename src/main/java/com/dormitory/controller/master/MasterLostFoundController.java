package com.dormitory.controller.master;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.LostFoundController;
import com.dormitory.dto.master.LostFoundDTO;
import com.dormitory.entity.LostFound;
import com.dormitory.entity.Master;
import com.dormitory.service.LostFoundService;
import com.dormitory.service.MasterService;

@Controller("masterLostFoundController")
@RequestMapping(value = "/master")
public class MasterLostFoundController extends LostFoundController {
	@Resource
	private MasterService masterService;

	/**
	 * 查看本楼的明信片
	 * 
	 * @param masterId
	 * @return
	 */
	@RequestMapping(value = "listLostFoundByMasterId.do")
	public ModelAndView listLostFoundByMasterId(@RequestParam(value = "masterId") Integer masterId,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		Master master = masterService.get(masterId);
		Integer buildingId = master.getBuildingId();
		List<LostFoundDTO> list = lostFoundService.listByBuildingId(buildingId, pageIndex, pageSize);
		Integer total = lostFoundService.getSizeByBuildingId(buildingId);
		Integer count = getTotalPages(total, pageSize);
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", count);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.setViewName("masterList/listLostFound");
		return modelAndView;
	}
	@RequestMapping(value = "forwardAddLostFound.do")
	public ModelAndView forwardAddLostFound(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("masterList/addLostFound");
		return modelAndView;
	}

}
