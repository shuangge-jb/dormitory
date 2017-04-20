package com.dormitory.entity;

public class Administrator extends User {
	protected Integer administratorId;

	public Administrator() {
		
	}

	public Integer getAdministratorId() {
		return administratorId;
	}

	public void setAdministratorId(Integer administratorId) {
		this.administratorId = administratorId;
	}

	@Override
	public String toString() {
		return "Administrator [administratorId=" + administratorId + ", name=" + name + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + ", password=" + password + "]";
	}

}
