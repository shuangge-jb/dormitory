package com.dormitory.dto;

import com.dormitory.entity.Dormitory;

public class DormitoryDTO extends Dormitory {
	protected String buildingName;

	public DormitoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DormitoryDTO(Dormitory dormitory) {
		super(dormitory);
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

}
