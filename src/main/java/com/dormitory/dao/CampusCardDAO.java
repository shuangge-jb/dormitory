package com.dormitory.dao;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import com.dormitory.entity.CampusCard;

public interface CampusCardDAO {

	@Select("select * from campus_card c where c.student_id=#{0}")
	@Results(value = {
            @Result(id = true, property = "campusCardId", column = "campus_card_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
            @Result(property = "studentId", column = "student_id", javaType = Long.class, jdbcType = JdbcType.DECIMAL),
            @Result(property = "cardBalance", column = "card_balance", javaType = BigDecimal.class, jdbcType = JdbcType.DECIMAL),
            @Result(property = "hotwaterBalance", column = "hotwater_balance", javaType = BigDecimal.class, jdbcType = JdbcType.DECIMAL)
            })
	CampusCard getCampusCard(Long studentId);

}