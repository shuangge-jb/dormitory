package com.dormitory.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dormitory.dao.ArticleDAO;
import com.dormitory.entity.Article;
import com.dormitory.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Resource
	private ArticleDAO articleDAO;
	
	

	public ArticleServiceImpl() {

	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public Article get(Long id) {
		return articleDAO.get(id);
	}

	@Transactional
	@Override
	public Article saveOrUpdate(Article article) {
		Article temp = articleDAO.get(article.getArticleId());
		if (temp == null) {
			articleDAO.save(article);
		} else {
			articleDAO.update(article);
		}
		return article;
	}

	@Transactional
	@Override
	public Article remove(Article article) {
		articleDAO.remove(article);
		return article;
	}

	@Override
	public List<Article> listByDormitoryId(Integer dormitoryId) {
		return articleDAO.listByDormitoryId(dormitoryId);
	}

	@Override
	public Long getLastInsertId() {
		return articleDAO.getLastInsertId();
	}

	

}
