package com.dormitory.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Building {
	//@NotNull
	Integer buildingId;
//	@NotNull(message = "doritory.buildingName.null")
//	@NotEmpty
//	@NotBlank
//	@Pattern(regexp = "[cC]([1][0-7]|[1-9])", message = "dormitory.room.illegal")
	protected String buildingName;

	public Building() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildngName() {
		return buildingName;
	}

	public void setBuildngName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Override
	public String toString() {
		return "Building [buildingId=" + buildingId + ", buildngName=" + buildingName + "]";
	}

}
