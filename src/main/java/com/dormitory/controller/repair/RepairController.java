package com.dormitory.controller.repair;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = "/repair")
public class RepairController {
	@Resource
	private RepairRecordService repairRecordService;
	protected static final Logger LOGGER = LoggerFactory.getLogger(RepairController.class);
	// TODO
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
		if (name.equals("admin") && password.equals("admin")) {
			return "adminMain";
		} else {
			return "redirect:../repair/login.jsp";
		}
	}

	@RequestMapping(value = "/removeRepairRecord.do", method = RequestMethod.POST)
	public ModelAndView removeRepairRecord(@RequestParam(value = "repairRecordId") Integer repairRecordId) {
		ModelAndView modelAndView = new ModelAndView("");
		RepairRecord record = repairRecordService.get(repairRecordId);
		repairRecordService.remove(record);
		return modelAndView;
	}
	@RequestMapping(value = "/listRepairRecord.do")
	@ResponseBody
	public String listRepairRecord(Integer pageIndex,Integer pageSize){
		List<RepairRecord> list=repairRecordService.list(pageIndex, pageSize);
		Integer total = repairRecordService.getSize();
		Integer count=getTotalPages(total, pageSize);
		Map<String,Object> map=new HashMap<String,Object>(5);
		map.put("data", list);
		map.put("totalPage", count);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		return toJSON(map);
	}
	private int getTotalPages(Integer count ,Integer pageSize){
		int totalPages = 0;
		totalPages = (count%pageSize==0)?(count/pageSize):(count/pageSize+1);
		return totalPages;
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
				LOGGER.debug("序列化对象时出错", e);
			}
		}
		return result;
	}
}
