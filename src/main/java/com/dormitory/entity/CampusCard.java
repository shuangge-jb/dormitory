package com.dormitory.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

public class CampusCard {
    private Integer campusCardId;

    private Long studentId;

    private BigDecimal cardBalance;

    private Double hotwaterBalance;

    public Integer getCampusCardId() {
        return campusCardId;
    }

    public void setCampusCardId(Integer cardId) {
        this.campusCardId = cardId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public BigDecimal getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(BigDecimal cardBalance) {
        this.cardBalance = cardBalance;
    }

    public Double getHotwaterBalance() {
        return hotwaterBalance;
    }

    public void setHotwaterBalance(Double hotwaterBalance) {
        this.hotwaterBalance = hotwaterBalance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cardId=").append(campusCardId);
        sb.append(", studentId=").append(studentId);
        sb.append(", cardBalance=").append(cardBalance);
        sb.append(", hotwaterBalance=").append(hotwaterBalance);
        sb.append("]");
        return sb.toString();
    }
}