package com.dormitory.dto;

import javax.validation.constraints.NotNull;

import com.dormitory.entity.Dormitory;
import com.dormitory.validator.StudentRegister;

public class DormitoryDTO extends Dormitory {
	@NotNull(groups={StudentRegister.class})
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
