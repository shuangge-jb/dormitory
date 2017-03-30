package com.dormitory.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

public class Electricity {
    private Integer dormitoryId;

    private Double restElectricity;

    private Double sumElectricity;

    private Double balance;

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Double getRestElectricity() {
        return restElectricity;
    }

    public void setRestElectricity(Double restElectricity) {
        this.restElectricity = restElectricity;
    }

    public Double getSumElectricity() {
        return sumElectricity;
    }

    public void setSumElectricity(Double sumElectricity) {
        this.sumElectricity = sumElectricity;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dormitoryId=").append(dormitoryId);
        sb.append(", restElectricity=").append(restElectricity);
        sb.append(", sumElectricity=").append(sumElectricity);
        sb.append(", balance=").append(balance);
        sb.append("]");
        return sb.toString();
    }
}