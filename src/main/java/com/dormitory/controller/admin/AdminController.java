package com.dormitory.controller.admin;

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

import com.dormitory.controller.student.StudentController;
import com.dormitory.entity.Master;
import com.dormitory.entity.Student;
import com.dormitory.service.AdminService;
import com.dormitory.service.MasterService;
import com.dormitory.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private AdminService adminService;
	@Resource
	private MasterService masterService;
	@Resource 
	private StudentService studentService;
	private static final String ERROR_PAGE = "error";
	protected static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
		if (name.equals("admin") && password.equals("admin")) {
			return "adminMain";
		} else {
			return "redirect:/login";
		}

	}

	@RequestMapping(value = "/saveOrUpdateMaster.do", method = RequestMethod.POST)
	public ModelAndView saveOrUpdateMaster(@ModelAttribute(value = "master") @Valid Master master,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName(ERROR_PAGE);
			return modelAndView;
		}
		masterService.saveOrUpdate(master);
		return modelAndView;
	}

	@RequestMapping(value = "/removeMaster.do", method = RequestMethod.POST)
	public ModelAndView removeMaster(@RequestParam(value = "masterId") Integer masterId) {
		ModelAndView modelAndView = new ModelAndView();
		Master master = masterService.get(masterId);
		masterService.remove(master);
		return modelAndView;
	}
	@RequestMapping(value = "/listMaster.do")
	@ResponseBody
	public String listMaster(){
		Map<String,Object> map=new HashMap<String,Object>(3);
		List<Master> list=masterService.list();
		Integer total=masterService.getSize();
		map.put("data", list);
		map.put("total", total);
		return toJSON(map);
	}
	
	@RequestMapping(value="removeStudent.do",method=RequestMethod.POST)
	public ModelAndView removeStudent(@RequestParam(value="studentId")Long studentId){
		ModelAndView modelAndView = new ModelAndView();
		Student student=studentService.get(studentId);
		studentService.remove(student);
		return modelAndView;
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
				LOGGER.debug("序列化Announcement对象时出错", e);
			}
		}
		return result;
	}
}
