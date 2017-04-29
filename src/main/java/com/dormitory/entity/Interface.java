package com.dormitory.entity;

public class Interface {
	protected Integer interfaceId;
	protected String interfaceName;
	protected String interfaceUrl;

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

	@Override
	public String toString() {
		return "Interface [interfaceId=" + interfaceId + ", interfaceName=" + interfaceName + ", interfaceUrl="
				+ interfaceUrl + "]";
	}

}
