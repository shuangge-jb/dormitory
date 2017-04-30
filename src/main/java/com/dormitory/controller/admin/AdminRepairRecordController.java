package com.dormitory.controller.admin;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.RepairRecordController;
import com.dormitory.entity.RepairRecord;

@Controller("adminRepairRecordController")
@RequestMapping(value = "/admin")
public class AdminRepairRecordController extends RepairRecordController {
	@RequestMapping(value = "saveOrUpdateRepairRecord.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateRepairRecord(
			@ModelAttribute(value = "repairRecord") @Valid RepairRecord repairRecord, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("");
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		repairRecordService.saveOrUpdate(repairRecord);
		modelAndView.addObject("status", "成功");
		return modelAndView;
	}

	@RequestMapping(value = "removeRepairRecord.do", method = RequestMethod.POST)
	public ModelAndView removeRepairRecord(@ModelAttribute(value = "repairRecord") @Valid RepairRecord repairRecord,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("");
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}

		repairRecordService.remove(repairRecord);
		modelAndView.addObject("status", "删除成功");
		return modelAndView;
	}
}
