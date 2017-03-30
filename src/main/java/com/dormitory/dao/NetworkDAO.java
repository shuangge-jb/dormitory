package com.dormitory.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import com.dormitory.entity.Network;

public interface NetworkDAO {
   
	@Select("select * from network n  where n.student_id=#{0} ")
	@Results(value = {
	        @Result(id = true, property = "studentId", column = "student_id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
	        @Result(property = "tariffPackage", column = "tariff_package", javaType = String.class, jdbcType = JdbcType.VARCHAR),
	        @Result(property = "money", column = "money", javaType = Integer.class, jdbcType = JdbcType.INTEGER)
	})
    Network getNetwork(Long studentId);

}