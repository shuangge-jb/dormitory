package com.dormitory.entity;

import java.util.Date;

public class Postcard {
    protected Integer postcardId;

    protected Long studentId;

    protected Integer dormitoryId;

    protected Date createTime;

    protected Integer state;

    public Integer getPostcardId() {
        return postcardId;
    }

    public void setPostcardId(Integer postcardId) {
        this.postcardId = postcardId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
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
        sb.append(", postcardId=").append(postcardId);
        sb.append(", studentId=").append(studentId);
        sb.append(", dormitoryId=").append(dormitoryId);
        sb.append(", createTime=").append(createTime);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}