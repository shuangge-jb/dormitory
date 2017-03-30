package com.dormitory.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import com.dormitory.entity.ElectricityRecord;

public interface ElectricityRecordDAO {
	@Select("select * from electricity_record r "
			+ " where r.dormitory_id=#{0}")
	@Results(value = {
			@Result(id = true, property = "electricityRecordId", column = "electricity_record_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "dormitoryId", column = "dormitory_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "money", column = "money", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "createTime", column = "create_time", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "payTime", column = "pay_time", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "buyElectricity", column = "buy_electricity", javaType = BigDecimal.class, jdbcType = JdbcType.DECIMAL),
			@Result(property = "state", column = "state", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	public List<ElectricityRecord> listElectricityRecord(Integer dormitoryId);

}