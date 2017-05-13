package com.dormitory.dto;

import com.dormitory.entity.Postcard;

public class PostcardDTO extends Postcard {
	protected String name;
	protected String buildingName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	@Override
	public String toString() {
		return "PostcardDTO [name=" + name + ", buildingName=" + buildingName + ", postcardId=" + postcardId
				+ ", studentId=" + studentId + ", dormitoryId=" + dormitoryId + ", createTime=" + createTime
				+ ", state=" + state + "]";
	}

}
