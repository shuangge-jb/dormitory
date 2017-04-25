package com.dormitory.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.dormitory.entity.Building;

public interface BuildingDAO {
	@Select("select * from building where building_id=#{0}")
	@ResultMap("com.dormitory.mapper.BuildingMapper.building")
	public Building get(Integer buildingId);

	@Select("select * from building where building_name=#{0}")
	@ResultMap("com.dormitory.mapper.BuildingMapper.building")
	public Building getByBuildingName(String buildingName);
}
