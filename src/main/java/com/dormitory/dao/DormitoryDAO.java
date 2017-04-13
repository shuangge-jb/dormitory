package com.dormitory.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.dormitory.entity.Dormitory;

public interface DormitoryDAO {

	@Select("select * from dormitory where dormitory_id=#{0} ")
	@ResultMap("com.dormitory.mapper.DormitoryMapper.dormitory")
	Dormitory getDormitory(Integer dormitoryId);

	
}