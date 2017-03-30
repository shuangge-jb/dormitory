package com.dormitory.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import com.dormitory.entity.Dormitory;

public interface DormitoryDAO {

	@Select("select * from dormitory where dormitory_id=#{0} ")
	@Results(value = {
            @Result(id = true, property = "dormitoryId", column = "dormitory_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "building", column = "building", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "room", column = "room", javaType = String.class, jdbcType = JdbcType.VARCHAR)
            })
	Dormitory getDormitory(Integer dormitoryId);

	
}