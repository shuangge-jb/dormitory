package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.dormitory.entity.ElectricityRecord;

public interface ElectricityRecordDAO {
	@Select("select * from electricity_record r "
			+ " where r.dormitory_id=#{0}")
	@ResultMap("com.dormitory.mapper.ElectricityRecordMapper.electricityRecord")
	public List<ElectricityRecord> listElectricityRecord(Integer dormitoryId);

}