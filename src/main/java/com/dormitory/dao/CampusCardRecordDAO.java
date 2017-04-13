package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.dormitory.entity.CampusCardRecord;

public interface CampusCardRecordDAO {

	@Select("select r.* from campus_card_record r join campus_card c "
			+" on r.campus_card_id=c.campus_card_id "
			+" where c.student_id=#{0}")
	@ResultMap("com.dormitory.mapper.CampusCardRecordMapper.campusCardRecord")
	List<CampusCardRecord> listCampusCardRecord(Long studentId);

}