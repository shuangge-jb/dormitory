package com.dormitory.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import com.dormitory.service.ArticleService;
import com.dormitory.service.dto.ArticleDTO;

@RequestMapping(value = "/article")
@SessionAttributes({ "studentId", "administratorId", "dormitoryId" })
@Controller
public class ArticleController {
	private static final String DIR = "/models/";
	private static final String ERROR_PAGE = "error";
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

	@Resource
	private ArticleService articleService;

	/*@InitBinder   
    protected   void  initBinder(WebDataBinder binder){  
        binder.setValidator(new  ArticleDTOValidator());  
    } */
	
	@RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
	public String saveArticle(@ModelAttribute(value = "article") @Valid ArticleDTO articleDTO, BindingResult articleDTOResult,
			@RequestParam(value = "file", required = false)  MultipartFile file,HttpServletRequest request,
			Model model) {
		if (articleDTOResult.hasErrors()) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("参数异常：result.hasErrors."+articleDTOResult);
			}
			return ERROR_PAGE;
		}
		if(!(file.getName().endsWith(".obj")||file.getName().endsWith(".dae"))){
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("file参数异常：");
			}
			return ERROR_PAGE;
		}
		String path = request.getSession().getServletContext().getRealPath("/");
		System.out.println("path:"+path);
		String contextPath = request.getContextPath();
		//System.out.println("contextPath:"+contextPath);
		String fileName = file.getOriginalFilename();
		System.out.println("fileName:"+fileName);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		String modelUrl = contextPath + DIR + fileName;
		articleDTO.setPath(modelUrl);
		System.out.println("saveArticle:" + articleDTO);
		// articleService.saveOrUpdate((Article)article);
		model.addAttribute("path", modelUrl);
		// 保存

		try {
			file.transferTo(targetFile);
		} catch (IllegalStateException e1) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("IllegalStateException at saveArticle:", e1);
			}
			return ERROR_PAGE;
		} catch (IOException e1) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("IOException at saveArticle:", e1);
			}
			return ERROR_PAGE;

		}
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("成功上传文件.");
		}
		System.out.println("文件路径" + modelUrl);
		return "success";
	}
}
