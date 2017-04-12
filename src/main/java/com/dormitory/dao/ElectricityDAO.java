package com.dormitory.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.dormitory.entity.Electricity;

public interface ElectricityDAO {

	@Select("select * from electricity e  where e.dormitory_id=#{0} ")
	@ResultMap("com.dormitory.mapper.ElectricityMapper.electricity")
	Electricity getElectricity(Integer dormitoryId);

}