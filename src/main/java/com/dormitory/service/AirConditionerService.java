package com.dormitory.service;

import com.dormitory.entity.AirConditioner;

public interface AirConditionerService {
	/**
	 * 查找
	 * @param dormitoryId
	 * @return
	 */
	public AirConditioner get(Integer dormitoryId);
}
