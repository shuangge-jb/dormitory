package com.dormitory.entity;

import java.sql.Timestamp;

public class LostFound {
	protected Integer lostFoundId;

	protected Long studentId;

	protected String content;

	protected Timestamp createTime;

	protected Integer state;
	protected String publisher;
	protected String place;

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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "LostFound [lostFoundId=" + lostFoundId + ", studentId=" + studentId + ", content=" + content
				+ ", createTime=" + createTime + ", state=" + state + ", publisher=" + publisher + ", place=" + place
				+ "]";
	}

}