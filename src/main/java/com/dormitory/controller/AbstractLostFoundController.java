package com.dormitory.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.LostFound;
import com.dormitory.service.LostFoundService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public abstract class AbstractLostFoundController {
	@Resource
	protected LostFoundService lostFoundService;
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	@RequestMapping(value = "listLostFound.do")
	@ResponseBody
	public String listLostFound(Integer pageIndex, Integer pageSize) {
		List<LostFound> list = lostFoundService.list(pageIndex, pageSize);
		return toJSON(list);
	}
	@RequestMapping(value = "listLostFoundByStudentId.do")
	@ResponseBody
	public String listLostFoundByStudentId(Long studentId,Integer pageIndex, Integer pageSize) {
		List<LostFound> list = lostFoundService.listByStudentId(studentId,pageIndex, pageSize);
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
				LOGGER.debug("序列化LostFound对象时出错", e);
			}
		}
		return result;
	}
}
