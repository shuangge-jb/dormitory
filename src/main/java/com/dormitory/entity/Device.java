package com.dormitory.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Device {
	protected Long deviceId;
	@NotEmpty(message = "${device.name.null}")
	@NotBlank
	@Length(min = 1, max = 20, message = "{device.name.length.illegal}")
	@Pattern(regexp = "^[\u4e00-\u9fa5_a-zA-Z0-9]+$", message = "{article.name.illegal}")
	protected String name;
	@NotNull
	@NotEmpty
	@NotBlank
	protected String type;
	protected String imgPath;
	@NotNull
	@NotEmpty
	@NotBlank
	protected String description;
	protected String modelPath;

	public Device() {
		// TODO Auto-generated constructor stub
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModelPath() {
		return modelPath;
	}

	public void setModelPath(String modelPath) {
		this.modelPath = modelPath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", name=" + name + ", type=" + type + ", imgPath=" + imgPath
				+ ", description=" + description + ", modelPath=" + modelPath + "]";
	}

}
