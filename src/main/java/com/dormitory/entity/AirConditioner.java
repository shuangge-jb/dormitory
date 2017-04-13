package com.dormitory.entity;

import java.math.BigDecimal;
import java.sql.Time;

public class AirConditioner {

    protected Integer dormitoryId;

    protected BigDecimal restAmount;

    protected BigDecimal sumAmount;

    protected Time restHours;


    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public BigDecimal getRestAmount() {
        return restAmount;
    }

    public void setRestAmount(BigDecimal restAmount) {
        this.restAmount = restAmount;
    }

    public BigDecimal getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(BigDecimal sumAmount) {
        this.sumAmount = sumAmount;
    }

    public Time getRestHours() {
        return restHours;
    }

    public void setRestHours(Time restHours) {
        this.restHours = restHours;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dormitoryId=").append(dormitoryId);
        sb.append(", restAmount=").append(restAmount);
        sb.append(", sumAmount=").append(sumAmount);
        sb.append(", restHours=").append(restHours);
        sb.append("]");
        return sb.toString();
    }
}