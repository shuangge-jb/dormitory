package com.dormitory.controller.admin;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dormitory.dto.master.MasterDTO;
import com.dormitory.entity.Master;
import com.dormitory.entity.Student;
import com.dormitory.service.AdminService;
import com.dormitory.service.FileService;
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
	@Resource
	private FileService fileService;
	private static final String ERROR_PAGE = "error";
	private static final String IMG_DIR = "/images/";
	protected static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
		if (name.equals("admin") && password.equals("admin")) {
			return "adminMain";
		} else {
			return "redirect:../admin/login.jsp";
		}

	}

	@RequestMapping(value = "/listMaster.do")
	@ResponseBody
	public String listMaster(@RequestParam(value = "pageIndex") Integer pageIndex,
			@RequestParam(value = "pageSize") Integer pageSize) {
		List<Master> list = masterService.list(pageIndex, pageSize);
		Integer total = masterService.getSize();
		Integer totalPage = getTotalPages(total, pageSize);
		Map<String, Object> map = new HashMap<String, Object>(4);
		map.put("data", list);
		map.put("total", total);
		map.put("totalPages", totalPage);
		map.put("pageIndex", pageIndex);
		map.put("pageSize", pageSize);
		return toJSON(map);

	}

	@RequestMapping(value = "/saveMaster.do", method = RequestMethod.POST)
	public ModelAndView saveMaster(@ModelAttribute(value = "master") @Valid MasterDTO masterDTO, BindingResult result,
			MultipartFile img, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("");
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(result.getFieldError().toString());
			}
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", "参数异常");
			return modelAndView;
		}
		
		if (img != null && (img.isEmpty() == false)) {
			fileService.saveFile(request, IMG_DIR, img);
			String imgPath = fileService.getFilePath(request, IMG_DIR, img);
			masterDTO.setImgPath(imgPath);
		}
		MasterDTO newMasterDTO = masterService.saveOrUpdate(masterDTO);
		modelAndView.addObject("data", newMasterDTO);
		return modelAndView;
	}

	@RequestMapping(value = "/updateMaster.do", method = RequestMethod.POST)
	public ModelAndView updateMaster(@ModelAttribute(value = "master") @Valid MasterDTO masterDTO, BindingResult result,
			MultipartFile img, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("");
		if (result.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(result.getFieldError().toString());
			}
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", "参数异常");
			return modelAndView;
		}
		Master oldMaster=masterService.get(masterDTO.getMasterId());
		System.out.println("oldMaster:"+oldMaster);
		if(oldMaster==null){
			modelAndView.setViewName(ERROR_PAGE);
			modelAndView.addObject("status", "用户不存在");
			return modelAndView;
		}
		//已上传图片
		if (img != null && (img.isEmpty() == false)) {
			fileService.saveFile(request, IMG_DIR, img);
			String imgPath = fileService.getFilePath(request, IMG_DIR, img);
			masterDTO.setImgPath(imgPath);
		}else{
			//未上传图片
			masterDTO.setImgPath(oldMaster.getImgPath());
		}
		masterService.saveOrUpdate(masterDTO);
		return modelAndView;
	}

	@RequestMapping(value = "/removeMaster.do", method = RequestMethod.POST)
	public ModelAndView removeMaster(@RequestParam(value = "masterId") Integer masterId) {
		ModelAndView modelAndView = new ModelAndView("");
		masterService.remove(masterId);
		return modelAndView;
	}

	@RequestMapping(value = "removeStudent.do", method = RequestMethod.POST)
	public ModelAndView removeStudent(@RequestParam(value = "studentId") Long studentId) {
		ModelAndView modelAndView = new ModelAndView("");
		Student student = studentService.get(studentId);
		studentService.remove(student.getStudentId());
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
				LOGGER.debug("序列化Announcement对象时出错", e);
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
