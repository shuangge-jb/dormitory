package com.dormitory.entity;

public class Paramater {
	protected Integer paramaterId;
	protected String paramaterName;
	protected String description;
	protected String type;
	protected Integer interfaceId;

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

	@Override
	public String toString() {
		return "Paramater [paramaterId=" + paramaterId + ", paramaterName=" + paramaterName + ", description="
				+ description + ", type=" + type + ", interfaceId=" + interfaceId + "]";
	}
}
