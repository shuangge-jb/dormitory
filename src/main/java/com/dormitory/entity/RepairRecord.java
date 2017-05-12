package com.dormitory.entity;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class RepairRecord {
	protected Integer repairRecordId;
	@NotNull
	protected Integer dormitoryId;
	@NotEmpty
	protected String deviceName;
	@NotEmpty
	protected String content;
	protected Double price;
	protected Integer state;
	protected Timestamp createTime;
	protected Timestamp repairTime;
	@NotNull
	protected Long contactId;
	@NotEmpty
	protected String description;
	@NotNull
	protected Long phoneNumber;

	public Integer getRepairRecordId() {
		return repairRecordId;
	}

	public void setRepairRecordId(Integer repairRecordId) {
		this.repairRecordId = repairRecordId;
	}

	public Integer getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(Integer dormitoryId) {
		this.dormitoryId = dormitoryId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getRepairTime() {
		return repairTime;
	}

	public void setRepairTime(Timestamp repairTime) {
		this.repairTime = repairTime;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "RepairRecord [repairRecordId=" + repairRecordId + ", dormitoryId=" + dormitoryId + ", deviceName="
				+ deviceName + ", content=" + content + ", price=" + price + ", state=" + state + ", createTime="
				+ createTime + ", repairTime=" + repairTime + ", contactId=" + contactId + ", description="
				+ description + ", phoneNumber=" + phoneNumber + "]";
	}

}