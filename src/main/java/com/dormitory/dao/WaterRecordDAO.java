package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.dormitory.entity.WaterRecord;

public interface WaterRecordDAO {
   
	@Select("select * from water_record r"
			+ " where  r.dormitory_id=#{0}")
	@ResultMap("com.dormitory.mapper.WaterRecordMapper.waterRecord")
    List<WaterRecord> listWaterRecord(Integer dormitoryId);

    
}