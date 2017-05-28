package com.dormitory.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.dormitory.validator.MasterLogin;
import com.dormitory.validator.MasterRegister;
import com.dormitory.validator.Register;

public class Master extends User {

	protected Integer masterId;

	protected Integer buildingId;
	protected Long idCard;
	protected Date entryTime;

	public Master() {

	}

	public Integer getMasterId() {
		return masterId;
	}

	public void setMasterId(Integer masterId) {
		this.masterId = masterId;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public Long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	@Override
	public String toString() {
		return "Master [masterId=" + masterId + ", buildingId=" + buildingId + ", idCard=" + idCard + ", entryTime="
				+ entryTime + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", password="
				+ password + ", outDate=" + outDate + ", validateCode=" + validateCode + ", imgPath=" + imgPath + "]";
	}

}
