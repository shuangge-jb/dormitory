package com.dormitory.controller;

import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.Postcard;
import com.dormitory.service.PostcardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class PostcardController {
	@Resource
	protected PostcardService postcardService;
	protected static final String ERROR_PAGE = "error";
	protected static final String OPERATE_SUCCESS = "操作成功";
	protected static final String REMOVE_SUCCESS = "删除成功";
	protected static final Logger LOGGER = LoggerFactory.getLogger(PostcardController.class);

	@RequestMapping(value = "getPostcard.do")
	@ResponseBody
	public String getPostcard(@RequestParam(value = "postcardId") Integer postcardId) {
		Postcard card = postcardService.get(postcardId);
		return toJSON(card);
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
				LOGGER.debug("序列化LostFound对象时出错", e);
			}
		}
		return result;
	}
}
