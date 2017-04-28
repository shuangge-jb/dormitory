package com.dormitory.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.dormitory.entity.Article;

public interface ArticleService
		extends GetService<Article,Long>,SaveOrUpdateService<Article>, 
		 RemoveService<Article>,
		ListByDormitoryIdService<Article>{

}
