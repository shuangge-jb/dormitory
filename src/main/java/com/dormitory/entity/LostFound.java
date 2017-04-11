package com.dormitory.entity;

import java.util.Date;

public class LostFound {
	protected Integer lostFoundId;

	protected Long studentId;

	protected String content;

	protected Date createTime;

	protected Integer state;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lostFoundId=").append(lostFoundId);
        sb.append(", studentId=").append(studentId);
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}