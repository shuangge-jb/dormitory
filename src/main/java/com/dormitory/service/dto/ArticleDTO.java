package com.dormitory.service.dto;

import java.io.File;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.dormitory.entity.Article;

public class ArticleDTO extends Article {
	@NotEmpty(message = "{article.file.null}")
	protected File file;

	public ArticleDTO() {
		// TODO Auto-generated constructor stub
	}

}
