package com.dormitory.entity;

import java.sql.Timestamp;
import java.util.Date;

public class WaterRecord {
    protected Integer waterRecordId;

    protected Integer dormitoryId;

    protected Integer money;

    protected Timestamp createTime;

    protected Timestamp payTime;

    protected String state;

    public Integer getWaterRecordId() {
        return waterRecordId;
    }

    public void setWaterRecordId(Integer waterRecordId) {
        this.waterRecordId = waterRecordId;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", waterRecordId=").append(waterRecordId);
        sb.append(", dormitoryId=").append(dormitoryId);
        sb.append(", money=").append(money);
        sb.append(", createTime=").append(createTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}