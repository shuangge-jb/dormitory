package com.dormitory.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import com.dormitory.entity.Water;

public interface WaterDAO {
	@Select("select * from water w  where w.dormitory_id=#{0} ")
	@Results(value = {
			@Result(id = true, property = "dormitoryId", column = "dormitory_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "prevReadout", column = "prev_readout", javaType = Long.class, jdbcType = JdbcType.DECIMAL),
			@Result(property = "prevTime", column = "prev_time", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "thisReadout", column = "this_readout", javaType = Long.class, jdbcType = JdbcType.DECIMAL),
			@Result(property = "thisTime", column = "this_time", javaType = Date.class, jdbcType = JdbcType.DATE) })
	Water getWater(Integer dormitoryId);

}