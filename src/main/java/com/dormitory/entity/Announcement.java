package com.dormitory.entity;

import java.sql.Timestamp;

public class Announcement {
	protected Integer announcementId;
	protected String title;
	protected String content;
	protected String imgPath;
	protected Integer authorId;
	protected Timestamp createTime;
	protected Integer importance;

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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
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

	@Override
	public String toString() {
		return "Announcement [announcementId=" + announcementId + ", title=" + title + ", content=" + content
				+ ", imgPath=" + imgPath + ", authorId=" + authorId + ", createTime=" + createTime + ", importance="
				+ importance + "]";
	}

}