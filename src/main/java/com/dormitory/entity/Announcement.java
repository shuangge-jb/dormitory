package com.dormitory.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Announcement {
	protected Integer announcementId;
	protected String title;
	@Size(max=255)
	@NotEmpty
	protected String content;
	protected String imgPath;
	@NotNull
	protected Integer authorId;
	@NotNull
	protected Date createTime;
	protected Integer importance;
	protected Integer buildingId;

	public Integer getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(Integer announcementId) {
		this.announcementId = announcementId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public Integer getImportance() {
		return importance;
	}

	public void setImportance(Integer importance) {
		this.importance = importance;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	@Override
	public String toString() {
		return "Announcement [announcementId=" + announcementId + ", title=" + title + ", content=" + content
				+ ", imgPath=" + imgPath + ", authorId=" + authorId + ", createTime=" + createTime + ", importance="
				+ importance + ", buildingId=" + buildingId + "]";
	}

}