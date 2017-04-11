package com.dormitory.entity;

import javax.persistence.Entity;


public class Network {
	protected Long studentId;

	protected String tariffPackage;

	protected Integer money;

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
		this.tariffPackage = tariffPackage == null ? null : tariffPackage
				.trim();
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", studentId=").append(studentId);
		sb.append(", tariffPackage=").append(tariffPackage);
		sb.append(", money=").append(money);
		sb.append("]");
		return sb.toString();
	}

	

	
}
