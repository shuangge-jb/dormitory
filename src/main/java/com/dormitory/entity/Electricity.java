package com.dormitory.entity;

import java.math.BigDecimal;








import javax.persistence.Entity;

public class Electricity {
	protected Integer dormitoryId;

	protected BigDecimal restElectricity;

	protected BigDecimal sumElectricity;

	protected BigDecimal balance;

	public Integer getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(Integer dormitoryId) {
		this.dormitoryId = dormitoryId;
	}

	public BigDecimal getRestElectricity() {
		return restElectricity;
	}

	public void setRestElectricity(BigDecimal restElectricity) {
		this.restElectricity = restElectricity;
	}

	public BigDecimal getSumElectricity() {
		return sumElectricity;
	}

	public void setSumElectricity(BigDecimal sumElectricity) {
		this.sumElectricity = sumElectricity;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
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
