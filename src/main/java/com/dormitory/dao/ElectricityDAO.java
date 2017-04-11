package com.dormitory.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import com.dormitory.entity.Electricity;

public interface ElectricityDAO {
   
@Select("select * from electricity e "
		+" where e.dormitory_id=#{0} ")
@Results(value = {
        @Result(id = true, property = "dormitoryId", column = "dormitory_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
        @Result(property = "restElectricity", column = "rest_electricity", javaType = Double.class, jdbcType = JdbcType.DECIMAL),
        @Result(property = "sumElectricity", column = "sum_electricity", javaType = Double.class, jdbcType = JdbcType.DECIMAL),
        @Result(property = "balance", column = "balance", javaType = Double.class, jdbcType = JdbcType.DECIMAL),
        })
    Electricity getElectricity(Integer dormitoryId);
   
}