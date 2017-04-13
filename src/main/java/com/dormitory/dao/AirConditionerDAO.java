package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.AirConditioner;
import com.dormitory.entity.RepairRecord;

public interface AirConditionerDAO {
	@Select("select * from air_conditioner where dormitory_id=#{dormitoryId}")
	@ResultMap("com.dormitory.mapper.AirConditionerMapper.airConditioner")
    public AirConditioner get(@Param("dormitoryId")Integer dormitoryId);
	
}