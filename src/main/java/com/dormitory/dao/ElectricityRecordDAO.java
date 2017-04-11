package com.dormitory.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.dormitory.entity.ElectricityRecord;

public interface ElectricityRecordDAO {
	@Select("select * from electricity_record r "
			+ " where r.dormitory_id=#{0}")
	@ResultMap("com.dormitory.mapper.ElectricityRecordMapper.electricityRecord")
	public List<ElectricityRecord> listElectricityRecord(Integer dormitoryId);

}