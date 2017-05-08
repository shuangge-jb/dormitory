package com.dormitory.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Paramater {
	protected Integer paramaterId;
	@NotNull
	@NotEmpty
	@NotBlank
	protected String paramaterName;
	@NotNull
	@NotEmpty
	@NotBlank
	protected String description;
	@NotNull
	protected String type;
	@NotNull
	protected Integer interfaceId;
	@NotNull
	protected Long deviceId;
	public Paramater() {
		super();
	}

	public Integer getParamaterId() {
		return paramaterId;
	}

	public void setParamaterId(Integer paramaterId) {
		this.paramaterId = paramaterId;
	}

	public String getParamaterName() {
		return paramaterName;
	}

	public void setParamaterName(String paramaterName) {
		this.paramaterName = paramaterName;
	}

	public Integer getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(Integer interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	@Override
	public String toString() {
		return "Paramater [paramaterId=" + paramaterId + ", paramaterName=" + paramaterName + ", description="
				+ description + ", type=" + type + ", interfaceId=" + interfaceId + ", deviceId=" + deviceId + "]";
	}

	
}
