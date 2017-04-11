package com.dormitory.entity;

import java.math.BigDecimal;

public class CampusCard {
	protected Integer campusCardId;

	protected Long studentId;

	protected BigDecimal cardBalance;


	protected BigDecimal hotwaterBalance;

	public Integer getCampusCardId() {
		return campusCardId;
	}

	public void setCampusCardId(Integer campusCardId) {
		this.campusCardId = campusCardId;
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


	public BigDecimal getHotwaterBalance() {
		return hotwaterBalance;
	}

	public void setHotwaterBalance(BigDecimal hotwaterBalance) {
		this.hotwaterBalance = hotwaterBalance;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", campusCardId=").append(campusCardId);
		sb.append(", studentId=").append(studentId);
		sb.append(", cardBalance=").append(cardBalance);
		sb.append(", hotwaterBalance=").append(hotwaterBalance);
		sb.append("]");
		return sb.toString();
	}

	
}
