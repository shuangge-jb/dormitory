package com.dormitory.entity;

import java.util.Date;

public class ElectricityRecord {
    private Integer electricityRecordId;

    private Integer dormitoryId;

    private Integer money;

    private Date createTime;

    private Date payTime;

    private Double buyElectricity;

    private String state;

    public Integer getElectricityRecordId() {
        return electricityRecordId;
    }

    public void setElectricityRecordId(Integer electricityRecordId) {
        this.electricityRecordId = electricityRecordId;
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

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Double getBuyElectricity() {
        return buyElectricity;
    }

    public void setBuyElectricity(Double buyElectricity) {
        this.buyElectricity = buyElectricity;
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
        sb.append(", electricityRecordId=").append(electricityRecordId);
        sb.append(", dormitoryId=").append(dormitoryId);
        sb.append(", money=").append(money);
        sb.append(", createTime=").append(createTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", buyElectricity=").append(buyElectricity);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}