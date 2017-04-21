package com.dormitory.controller;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.dormitory.entity.Article;
import com.dormitory.service.ArticleService;


@RequestMapping(value = "/article")
@SessionAttributes({ "studentId", "administratorId", "dormitoryId" })
@Controller
public class ArticleController {
	private static final String DIR = "/models/";
	private static final String ERROR_PAGE="error";
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/saveArticle", method = RequestMethod.POST)
	public String saveArticle(@ModelAttribute(value = "article") @Valid Article article, BindingResult result,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			Model model) {
		if (result.hasErrors()) {
			return ERROR_PAGE;
		}
		String path = request.getSession().getServletContext().getRealPath("models");
		String contextPath = request.getContextPath();
		String fileName = file.getOriginalFilename();
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		String modelUrl = contextPath + DIR + fileName;
		article.setPath(modelUrl);
		System.out.println("saveArticle:" + article);
		// articleService.saveOrUpdate(article);
		model.addAttribute("path", modelUrl);
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("异常：saveArticle exception:", e);
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
