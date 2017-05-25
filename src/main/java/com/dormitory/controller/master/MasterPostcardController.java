package com.dormitory.controller.master;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.PostcardController;
import com.dormitory.dto.PostcardDTO;
import com.dormitory.entity.Master;
import com.dormitory.entity.Postcard;
import com.dormitory.service.MasterService;
import com.dormitory.service.PostcardService;

@Controller
@RequestMapping(value = "/master")
public class MasterPostcardController extends PostcardController {
	@Resource
	private MasterService masterService;

	/**
	 * 查看本楼的明信片
	 * 
	 * @param masterId
	 * @return
	 */
	@RequestMapping(value = "listPostcardByMasterId.do")
	public ModelAndView listPostcardByMasterId(@RequestParam(value = "masterId") Integer masterId,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView();
		Master master=masterService.get(masterId);
		Integer buildingId=master.getBuildingId();
		List<PostcardDTO> list = postcardService.listByBuildingId(buildingId, pageIndex, pageSize);
		Integer total=postcardService.getSizeByBuildingId(buildingId);
		Integer totalPage = getTotalPages(total, pageSize);
		modelAndView.setViewName("masterList/listPostCard");
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("result", list != null);
		return modelAndView;
	}
	@RequestMapping(value ="/forwardAddPostCard.do")
    public ModelAndView forwardAddAnnouncement(){
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("masterList/addPostCard");
    	return modelAndView;
    }
}
