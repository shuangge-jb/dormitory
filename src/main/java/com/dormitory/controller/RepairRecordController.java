package com.dormitory.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.entity.RepairRecord;
import com.dormitory.service.RepairRecordService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class RepairRecordController {
	@Resource
	protected RepairRecordService repairRecordService;
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final Logger LOGGER = LoggerFactory.getLogger(RepairRecordController.class);

	@RequestMapping(value = "listRepairRecord.do")
	@ResponseBody
	public String listRepairRecord(@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		List<RepairRecord> list = repairRecordService.list(pageIndex, pageSize);
		Integer total = repairRecordService.getSize();
		Integer totalPage = getTotalPages(total, pageSize);
		Map<String, Object> map = new HashMap<String, Object>(6);
		map.put("data", list);
		map.put("total", total);
		map.put("totalPages", totalPage);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		map.put("result", list != null);
		return toJSON(map);
	}

	@RequestMapping(value = "listRepairRecordLimit.do")
	@ResponseBody
	public String listRepairRecordLimit(@RequestParam(value = "n") Integer n) {
		List<RepairRecord> list = repairRecordService.listLimit(n);
		return toJSON(list);
	}

	// @RequestMapping(value = "listRepairRecordByDormitoryId.do")
	// @ResponseBody
	// public String listRepairRecordByDormitoryId(@RequestParam(value =
	// "dormitoryId") Integer dormitoryId,
	// @RequestParam(value = "pageIndex") Integer pageIndex, @RequestParam(value
	// = "pageSize") Integer pageSize) {
	// List<RepairRecord> list =
	// repairRecordService.listByDormitoryId(dormitoryId, pageIndex, pageSize);
	// Integer total = repairRecordService.getSizeByDormitoryId(dormitoryId);
	// Map<String, Object> map = new HashMap<String, Object>(3);
	// map.put("data", list);
	// map.put("total", total);
	// return toJSON(map);
	// }

	@RequestMapping(value = "getRepairRecord.do")
	@ResponseBody
	public String getRepiarRecord(@RequestParam(value = "repairRecordId") Integer repairRecordId) {
		RepairRecord record = repairRecordService.get(repairRecordId);
		return toJSON(record);
	}

	@RequestMapping(value = "saveRepairRecord.do", method = RequestMethod.POST)
	public ModelAndView saveRepairRecord(@ModelAttribute(value = "repairRecord") @Valid RepairRecord repairRecord,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("");
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		repairRecord.setCreateTime(new Timestamp(System.currentTimeMillis()));
		repairRecordService.saveOrUpdate(repairRecord);
		modelAndView.addObject("status", "成功");
		return modelAndView;
	}

	@RequestMapping(value = "removeRepairRecord.do", method = RequestMethod.POST)
	public ModelAndView removeRepairRecord(@RequestParam(value = "repairRecordId") Integer repairRecordId) {
		ModelAndView modelAndView = new ModelAndView("");
		repairRecordService.remove(repairRecordId);
		modelAndView.addObject("status", "删除成功");
		return modelAndView;
	}

	protected String toJSON(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

	protected int getTotalPages(Integer count, Integer pageSize) {
		if (pageSize == null) {
			pageSize = 10;
		}
		int totalPages = 0;
		totalPages = (count % pageSize == 0) ? (count / pageSize) : (count / pageSize + 1);
		return totalPages;
	}
}
