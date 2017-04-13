package com.dormitory.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.dormitory.entity.AirConditioner;

public interface AirConditionerDAO {
	@Select("select * from air_conditioner where dormitory_id=#{dormitoryId}")
	@ResultMap("com.dormitory.mapper.AirConditionerMapper.airConditioner")
    public AirConditioner get(@Param("dormitoryId")Integer dormitoryId);
	
}