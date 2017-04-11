package com.dormitory.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.dormitory.entity.Water;

public interface WaterDAO {
	@Select("select * from water w  where w.dormitory_id=#{0} ")
	@ResultMap("com.dormitory.mapper.WaterMapper.water")
	Water getWater(Integer dormitoryId);

}