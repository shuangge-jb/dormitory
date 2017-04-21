package com.dormitory.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Article {
	private Long articleId;
	private Integer dormitoryId;
	private Long studentId;
	@NotEmpty(message = "${article.name.null}")
	@Length(min = 5, max = 20, message = "{article.name.length.illegal}")
	@Pattern(regexp = "[a-zA-Z]{5,20}", message = "{article.name.illegal}")
	private String name;
	private Integer type;
	private Integer state;
	private String path;

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public Integer getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(Integer dormitoryId) {
		this.dormitoryId = dormitoryId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", dormitoryId=" + dormitoryId + ", studentId=" + studentId
				+ ", name=" + name + ", type=" + type + ", state=" + state + ", path=" + path + "]";
	}

}
