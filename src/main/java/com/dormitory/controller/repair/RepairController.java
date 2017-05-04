package com.dormitory.controller.repair;

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
@RequestMapping(value = "/repair")
public class RepairController {
	@Resource
	private RepairRecordService repairRecordService;
	protected static final String ERROR_PAGE = "error";
	protected static final Logger LOGGER = LoggerFactory.getLogger(RepairController.class);
	// TODO
	@RequestMapping(value = "/repairLogin.do", method = RequestMethod.POST)
	public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
		if (name.equals("repair") && password.equals("repair")) {
			return "repairMain";
		} else {
			return "redirect:../repair/login.jsp";
		}
	}

	@RequestMapping(value = "/listRepairRecord.do")
	@ResponseBody
	public String listRepairRecord(Integer pageIndex,Integer pageSize){
		List<RepairRecord> list=repairRecordService.list(pageIndex, pageSize);
		Integer total = repairRecordService.getSize();
		Integer totalPage=getTotalPages(total, pageSize);
		Map<String,Object> map=new HashMap<String,Object>(5);
		map.put("data", list);
		map.put("total", total);
		map.put("totalPages", totalPage);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		map.put("result", list!=null);
		return toJSON(map);
	}
	/**
	 * 维修部改变维修记录的状态
	 * @param repairRecord
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "updateRepairRecord.do", method = RequestMethod.POST)
	public ModelAndView updateRepairRecord(
			@ModelAttribute(value = "repairRecord") @Valid RepairRecord repairRecord, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("");
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		repairRecord.setRepairTime(new Timestamp(System.currentTimeMillis()));//记录维修时间
		repairRecordService.saveOrUpdate(repairRecord);
		modelAndView.addObject("status", "成功");
		return modelAndView;
	}
	private int getTotalPages(Integer count ,Integer pageSize){
		if(pageSize==null){
			pageSize=10;
		}
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
