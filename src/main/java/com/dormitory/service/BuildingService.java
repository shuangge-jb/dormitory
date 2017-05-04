package com.dormitory.service;

import com.dormitory.entity.Building;

public interface BuildingService {
	public Building getByBuildingName(String buildingName);
	public Building get(Integer buildingid);
}
