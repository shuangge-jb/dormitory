package com.dormitory.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class LostFound {
	protected Integer lostFoundId;

	protected Long studentId;

	protected String content;

	protected Date createTime;

	protected Integer state;
	protected Integer publisherId;
	protected String place;
	protected String imgPath;

	public Integer getLostFoundId() {
		return lostFoundId;
	}

	public void setLostFoundId(Integer lostFoundId) {
		this.lostFoundId = lostFoundId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	@Override
	public String toString() {
		return "LostFound [lostFoundId=" + lostFoundId + ", studentId=" + studentId + ", content=" + content
				+ ", createTime=" + createTime + ", state=" + state + ", publisherId=" + publisherId + ", place="
				+ place + ", imgPath=" + imgPath + "]";
	}

}