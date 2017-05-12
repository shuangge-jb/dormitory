package com.dormitory.controller.student;

import java.sql.Timestamp;
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

import com.dormitory.controller.RepairRecordController;
import com.dormitory.entity.RepairRecord;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.StudentService;

@Controller("studentRepairRecordController")
@RequestMapping(value = "/student")
public class StudentRepairRecordController extends RepairRecordController {
	@Resource
	private StudentService studentService;
	@Resource
	private DormitoryService dormitoryService;

	@RequestMapping(value = "listRepairRecordByDormitoryId.do")
	public ModelAndView listRepairRecordByDormitoryId(@RequestParam("dormitoryId") Integer dormitoryId,
			@RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize) {
		List<RepairRecord> list = repairRecordService.listByDormitoryId(dormitoryId, pageIndex, pageSize);
		Integer total = repairRecordService.getSizeByDormitoryId(dormitoryId);
		Integer totalPage=getTotalPages(total, pageSize);
		ModelAndView modelAndView = new ModelAndView("studentAnnoucment/myRepair");
		modelAndView.addObject("data", list);
		modelAndView.addObject("total", total);
		modelAndView.addObject("totalPages", totalPage);
		modelAndView.addObject("pageIndex", pageIndex);
		modelAndView.addObject("pageSize", pageSize);
		modelAndView.addObject("dormitoryId", dormitoryId);
		return modelAndView;
	}
	/**
	 * 学生提交维修记录
	 * @param repairRecord
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "saveRepairRecord.do", method = RequestMethod.POST)
	public ModelAndView saveRepairRecord(@ModelAttribute(value = "repairRecord") @Valid RepairRecord repairRecord,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("studentAnnoucment/applyRepair");
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().toString());
			modelAndView.addObject("status", "输入的数据有误，请检查");
			return modelAndView;
		}
		repairRecord.setCreateTime(new Timestamp(System.currentTimeMillis()));
		repairRecordService.saveOrUpdate(repairRecord);
		modelAndView.addObject("status", "成功提交");
		return modelAndView;
	}
	
	/**
	 * 学生修改维修记录
	 * @param repairRecord
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "studentUpdateRepairRecord.do", method = RequestMethod.POST)
	public ModelAndView updateRepairRecord(
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
	
	/**
	 * 跳转到报修页面
	 * @return
	 */
	@RequestMapping(value = "forwardRepair.do")
	public ModelAndView forwardRepair(@RequestParam(value="dormitoryId")Integer dormitoryId){
		ModelAndView modelAndView = new ModelAndView("");
		return modelAndView;
	}
}
