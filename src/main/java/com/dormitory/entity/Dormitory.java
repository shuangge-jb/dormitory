package com.dormitory.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.dormitory.validator.Register;
import com.dormitory.validator.StudentRegister;

public class Dormitory {
	
	protected Integer dormitoryId;
	
	protected Integer buildingId;
	@NotNull(message = "doritory.room.null", groups = { StudentRegister.class })
	@NotEmpty(message = "dormitory.room.empty", groups = { StudentRegister.class })
	@NotBlank(groups = { StudentRegister.class })
	@Pattern(regexp = "[1-7][0-5][0-9]", message = "dormitory.room.illegal", groups = { StudentRegister.class })
	protected String room;

	public Dormitory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dormitory(Dormitory dormitory) {
		super();
		this.buildingId = dormitory.buildingId;
		this.dormitoryId = dormitory.dormitoryId;
		this.room = dormitory.room;
	}

	public Integer getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(Integer dormitoryId) {
		this.dormitoryId = dormitoryId;
	}

	public Integer getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
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
		sb.append(", buildingId=").append(buildingId);
		sb.append(", room=").append(room);
		sb.append("]");
		return sb.toString();
	}

}
