package com.dormitory.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Device {
	protected Long deviceId;
	@NotNull(message="${device.dormitoryId.null}")
	protected Integer dormitoryId;
	@NotNull(message="${device.studentId.null}")
	protected Long studentId;
	@NotEmpty(message = "${device.name.null}")
	@Length(min = 1, max = 20, message = "{device.name.length.illegal}")
	@Pattern(regexp = "^[\u4e00-\u9fa5_a-zA-Z0-9]+$", message = "{article.name.illegal}")
	protected String name;
	protected Integer type;
	protected Integer state;
	protected String path;

	public Device() {
		// TODO Auto-generated constructor stub
	}


	public Long getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}


	public Integer getDormitoryId() {
		return dormitoryId;
	}

	public void setDormitoryId(Integer dormitoryId) {
		this.dormitoryId = dormitoryId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "Article [deviceId=" + deviceId + ", dormitoryId=" + dormitoryId + ", studentId=" + studentId
				+ ", name=" + name + ", type=" + type + ", state=" + state + ", path=" + path + "]";
	}

}
