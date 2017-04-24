package com.dormitory.dto;

import java.io.File;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.dormitory.validator.FileType;
import com.dormitory.entity.Article;

public class ArticleDTO extends Article {
	//@NotEmpty(message = "{article.file.null}")
	//@FileType(message="{article.file.type.illegal}")
	protected File file;

	public ArticleDTO() {
		// TODO Auto-generated constructor stub
	}

	public File getFile() {
		return file;
	}

	@Override
	public String toString() {
		return "ArticleDTO [file=" + file + ", articleId=" + articleId + ", dormitoryId=" + dormitoryId + ", studentId="
				+ studentId + ", name=" + name + ", type=" + type + ", state=" + state + ", path=" + path + "]";
	}

}
