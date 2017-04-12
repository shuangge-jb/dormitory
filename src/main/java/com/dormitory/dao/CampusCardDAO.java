package com.dormitory.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.dormitory.entity.CampusCard;

public interface CampusCardDAO {

	@Select("select c.* from campus_card c where c.student_id=#{0}")
	@ResultMap("com.dormitory.mapper.CampusCardMapper.campusCard")
	CampusCard getCampusCard(Long studentId);

}