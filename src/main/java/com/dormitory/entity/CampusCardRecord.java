package com.dormitory.entity;

import java.util.Date;

public class CampusCardRecord {
    private Integer campusCardRecordId;

	private Integer campusCardId;

	private String business;

	private Integer money;

	private Date createTime;

	private Date payTime;

	private String state;

	public Integer getCampusCardRecordId() {
		return campusCardRecordId;
	}

	public void setCampusCardRecordId(Integer campusCardRecordId) {
		this.campusCardRecordId = campusCardRecordId;
	}

	public Integer getCampusCardId() {
		return campusCardId;
	}

	public void setCampusCardId(Integer campusCardId) {
		this.campusCardId = campusCardId;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business == null ? null : business.trim();
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
		sb.append(", campusCardRecordId=").append(campusCardRecordId);
		sb.append(", campusCardId=").append(campusCardId);
		sb.append(", business=").append(business);
		sb.append(", money=").append(money);
		sb.append(", createTime=").append(createTime);
		sb.append(", payTime=").append(payTime);
		sb.append(", state=").append(state);
		sb.append("]");
		return sb.toString();
	}

	
}