package com.dormitory.controller.student;

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
	@ResponseBody
	public String listRepairRecordByDormitoryId(@RequestParam("dormitoryId") Integer dormitoryId,
			@RequestParam("pageIndex") Integer pageIndex, @RequestParam("pageSize") Integer pageSize) {
		List<RepairRecord> list = repairRecordService.listByDormitoryId(dormitoryId, pageIndex, pageSize);
		Integer total = repairRecordService.getSizeByDormitoryId(dormitoryId);
		Integer totalPage=getTotalPages(total, pageSize);
		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put("data", list);
		map.put("total", total);
		map.put("totalPages", totalPage);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		map.put("result", list!=null);
		return toJSON(map);
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
}
