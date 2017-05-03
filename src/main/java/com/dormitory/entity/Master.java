package com.dormitory.entity;

import javax.validation.constraints.NotNull;

import com.dormitory.validator.MasterLogin;
import com.dormitory.validator.MasterRegister;
import com.dormitory.validator.Register;

public class Master extends User {
	
	protected Integer masterId;
	
	protected Integer buildingId;

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

	@Override
	public String toString() {
		return "Master [masterId=" + masterId + ", buildingId=" + buildingId + ", name=" + name + ", phoneNumber="
				+ phoneNumber + ", email=" + email + ", password=" + password + ", outDate=" + outDate
				+ ", validateCode=" + validateCode + ", imgPath=" + imgPath + "]";
	}

	
}
