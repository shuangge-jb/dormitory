package com.dormitory.entity;

public class Paramater {
	protected Integer paramaterId;
	protected String paramaterName;
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

	@Override
	public String toString() {
		return "Paramater [paramaterId=" + paramaterId + ", paramaterName=" + paramaterName + ", interfaceId="
				+ interfaceId + "]";
	}

}
