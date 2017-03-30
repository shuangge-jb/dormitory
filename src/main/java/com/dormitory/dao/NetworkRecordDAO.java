package com.dormitory.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import com.dormitory.entity.NetworkRecord;

public interface NetworkRecordDAO {
   
	@Select("select * from network_record r "
			+ " where  r.student_id=#{0}")
	@Results(value = {
			@Result(id = true, property = "networkRecordId", column = "network_record_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "studentId", column = "student_id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
			@Result(property = "tariffPackage", column = "tariff_package", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "money", column = "money", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "createTime", column = "create_time", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "payTime", column = "pay_time", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "state", column = "state", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
    List<NetworkRecord> listNetworkRecord(Long studentId);

    
}