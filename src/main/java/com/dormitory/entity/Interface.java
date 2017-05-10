package com.dormitory.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Interface {
	protected Integer interfaceId;
	@NotNull
	@NotEmpty
	@NotBlank
	protected String interfaceName;
	@NotNull
	@NotEmpty
	@NotBlank
	protected String interfaceUrl;
	@NotNull
	@NotEmpty
	@NotBlank
	protected String description;
	@NotNull
	@NotEmpty
	@NotBlank
	protected String source;
	@NotNull
	protected Long deviceId;
	protected String method;

	protected Integer state;
	public Interface() {
		super();
	}

	public Integer getInterfaceId() {
		return interfaceId;
	}

	public void setInterfaceId(Integer interfaceId) {
		this.interfaceId = interfaceId;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getInterfaceUrl() {
		return interfaceUrl;
	}

	public void setInterfaceUrl(String interfaceUrl) {
		this.interfaceUrl = interfaceUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Interface [interfaceId=" + interfaceId + ", interfaceName=" + interfaceName + ", interfaceUrl="
				+ interfaceUrl + ", description=" + description + ", source=" + source + ", deviceId=" + deviceId
				+ ", method=" + method + ", state=" + state + "]";
	}


}
