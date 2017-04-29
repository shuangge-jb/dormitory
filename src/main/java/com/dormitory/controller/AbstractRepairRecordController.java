package com.dormitory.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.entity.RepairRecord;
import com.dormitory.service.RepairRecordService;

@Controller
public abstract class AbstractRepairRecordController {
	@Resource
	protected RepairRecordService repairRecordService;
	protected static final String ERROR_PAGE = "error";
	@RequestMapping(value = "listRepairRecord.do")
	public ModelAndView listRepairRecord(@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("");
		List<RepairRecord>list=repairRecordService.list(pageIndex, pageSize);
		modelAndView.addObject("repairRecord", list);
		return modelAndView;
	}

	@RequestMapping(value = "listRepairRecordLimit.do")
	public ModelAndView listRepairRecordLimit(@RequestParam(value = "n") Integer n) {
		ModelAndView modelAndView = new ModelAndView("");
		List<RepairRecord>list=repairRecordService.listLimit(n);
		modelAndView.addObject("repairRecord", list);
		return modelAndView;
	}

	@RequestMapping(value = "listRepairRecordByDormitoryId.do")
	public ModelAndView listRepairRecordByDormitoryId(@RequestParam(value = "dormitoryId") Integer dormitoryId,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize) {
		ModelAndView modelAndView = new ModelAndView("");
		List<RepairRecord>list=repairRecordService.listByDormitoryId(dormitoryId,pageIndex,pageSize);
		modelAndView.addObject("repairRecord", list);
		return modelAndView;
	}
}
