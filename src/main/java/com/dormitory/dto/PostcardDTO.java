package com.dormitory.dto;

import com.dormitory.entity.Postcard;

public class PostcardDTO extends Postcard {
	
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
		return "PostcardDTO [buildingName=" + buildingName + ", postcardId=" + postcardId + ", name=" + name
				+ ", buildingId=" + buildingId + ", createTime=" + createTime + ", state=" + state + "]";
	}

	

}
