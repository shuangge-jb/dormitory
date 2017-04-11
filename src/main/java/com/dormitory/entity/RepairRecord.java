package com.dormitory.entity;

import java.util.Date;

public class RepairRecord {
    protected Integer repairRecordId;

    protected Integer dormitoryId;

    protected String content;

    protected Integer state;

    protected Date createTime;

    protected Date repairTime;

    public Integer getRepairRecordId() {
        return repairRecordId;
    }

    public void setRepairRecordId(Integer repairRecordId) {
        this.repairRecordId = repairRecordId;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", repairRecordId=").append(repairRecordId);
        sb.append(", dormitoryId=").append(dormitoryId);
        sb.append(", content=").append(content);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", repairTime=").append(repairTime);
        sb.append("]");
        return sb.toString();
    }
}