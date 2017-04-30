package com.dormitory.entity;

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
		return "Administrator [masterId=" + masterId + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", password=" + password + "]";
	}
}
