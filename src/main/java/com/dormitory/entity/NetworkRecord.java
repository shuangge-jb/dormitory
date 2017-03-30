package com.dormitory.entity;

import java.util.Date;

public class NetworkRecord {
    private Integer networkRecordId;

    private Long studentId;

    private String tariffPackage;

    private Integer money;

    private Date createTime;

    private Date payTime;

    private String state;

    public Integer getNetworkRecordId() {
        return networkRecordId;
    }

    public void setNetworkRecordId(Integer networkRecordId) {
        this.networkRecordId = networkRecordId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getTariffPackage() {
        return tariffPackage;
    }

    public void setTariffPackage(String tariffPackage) {
        this.tariffPackage = tariffPackage == null ? null : tariffPackage.trim();
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

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
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
        sb.append(", networkRecordId=").append(networkRecordId);
        sb.append(", studentId=").append(studentId);
        sb.append(", tariffPackage=").append(tariffPackage);
        sb.append(", money=").append(money);
        sb.append(", createTime=").append(createTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}