package com.dormitory.controller.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		map.put("totalPage", totalPage);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		return toJSON(map);
	}
	
}
