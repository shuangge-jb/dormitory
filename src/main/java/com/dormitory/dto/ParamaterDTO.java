package com.dormitory.dto;

import com.dormitory.entity.Paramater;

public class ParamaterDTO extends Paramater {
	private String functionName;
	private String deviceName;

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Override
	public String toString() {
		return "ParamaterDTO [functionName=" + functionName + ", deviceName=" + deviceName + ", paramaterId="
				+ paramaterId + ", paramaterName=" + paramaterName + ", description=" + description + ", type=" + type
				+ ", interfaceId=" + interfaceId + ", deviceId=" + deviceId + "]";
	}

}
