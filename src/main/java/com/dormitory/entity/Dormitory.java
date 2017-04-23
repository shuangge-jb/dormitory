package com.dormitory.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Dormitory {
	@NotNull
	protected Integer dormitoryId;
	@NotNull(message = "doritory.building.null")
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "[cC][1-9]|[1][0-7]",message="dormitory.room.illegal")
	protected String building;
	@NotNull(message = "doritory.room.null")
	@NotEmpty
	@NotBlank
	@Pattern(regexp = "[1-7][0-5][0-9]",message="dormitory.room.illegal")
	protected String room;

	public Integer getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(Integer dormitoryId) {
		this.dormitoryId = dormitoryId;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building == null ? null : building.trim();
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room == null ? null : room.trim();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", dormitoryId=").append(dormitoryId);
		sb.append(", building=").append(building);
		sb.append(", room=").append(room);
		sb.append("]");
		return sb.toString();
	}

}
