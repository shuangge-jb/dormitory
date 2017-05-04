package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.BuildingDAO;
import com.dormitory.entity.Building;
import com.dormitory.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	@Resource
	private BuildingDAO buildingDAO;

	@Override
	public Building getByBuildingName(String buildingName) {
		return buildingDAO.getByBuildingName(buildingName);
	}

	@Override
	public Building get(Integer buildingId) {
		return buildingDAO.get(buildingId);
	}

}
