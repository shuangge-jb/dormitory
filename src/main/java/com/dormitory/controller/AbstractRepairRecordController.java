package com.dormitory.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.RepairRecord;
import com.dormitory.service.RepairRecordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public abstract class AbstractRepairRecordController {
	@Resource
	protected RepairRecordService repairRecordService;
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractRepairRecordController.class);
	@RequestMapping(value = "listRepairRecord.do")
	@ResponseBody
	public String listRepairRecord(@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		List<RepairRecord>list=repairRecordService.list(pageIndex, pageSize);
		return toJSON(list);
	}

	@RequestMapping(value = "listRepairRecordLimit.do")
	@ResponseBody
	public String listRepairRecordLimit(@RequestParam(value = "n") Integer n) {
		List<RepairRecord>list=repairRecordService.listLimit(n);
		return toJSON(list);
	}

	@RequestMapping(value = "listRepairRecordByDormitoryId.do")
	@ResponseBody
	public String listRepairRecordByDormitoryId(@RequestParam(value = "dormitoryId") Integer dormitoryId,
			@RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value = "pageSize") Integer pageSize) {
		List<RepairRecord>list=repairRecordService.listByDormitoryId(dormitoryId,pageIndex,pageSize);
		return toJSON(list);
	}
	protected String toJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(format);
		String result = null;
		try {
			result = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("序列化RepairRecord对象时出错", e);
			}
		}
		return result;
	}
}
