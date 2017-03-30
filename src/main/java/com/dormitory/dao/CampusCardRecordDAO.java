package com.dormitory.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import com.dormitory.entity.CampusCardRecord;

public interface CampusCardRecordDAO {

	@Select("select * from campus_card_record r"
			+" where r.student_id=#{0}")
	@Results(value = {
			@Result(id = true, property = "campusCardRecordId", column = "campus_card_record_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "campusCardId", column = "campus_card_id", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "business", column = "business", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(property = "money", column = "money", javaType = Integer.class, jdbcType = JdbcType.INTEGER),
			@Result(property = "createTime", column = "create_time", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "payTime", column = "pay_time", javaType = Date.class, jdbcType = JdbcType.DATE),
			@Result(property = "state", column = "state", javaType = String.class, jdbcType = JdbcType.VARCHAR) })
	List<CampusCardRecord> listCampusCardRecord(Long studentId);

}