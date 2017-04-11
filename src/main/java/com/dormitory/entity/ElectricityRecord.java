package com.dormitory.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ElectricityRecord {
	protected Integer electricityRecordId;

	protected Integer dormitoryId;

	protected Integer money;

	protected Timestamp  createTime;

	protected Timestamp  payTime;

	protected BigDecimal buyElectricity;

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

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}

	public BigDecimal getBuyElectricity() {
		return buyElectricity;
	}

	public void setBuyElectricity(BigDecimal buyElectricity) {
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
