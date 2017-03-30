package com.dormitory.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import com.dormitory.entity.Student;

public interface StudentDAO {
    
	@Select("select * from student where student_id=#{0}")
	@Results(value = {
            @Result(id = true, property = "studentId", column = "student_id", javaType = Long.class, jdbcType = JdbcType.BIGINT),
            @Result( property = "dormitoryId", column = "dormitory_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result( property = "bedId", column = "bed_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "name", column = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "phoneNumber", column = "phone_number", javaType = Long.class, jdbcType = JdbcType.DECIMAL),
            @Result(property = "email", column = "email", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(property = "password", column = "password", javaType = String.class, jdbcType = JdbcType.VARCHAR)
            })
    Student getStudent(Long studentId);

   
}