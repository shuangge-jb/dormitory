package com.dormitory.dao;

import com.dormitory.entity.CampusCardRecord;

public interface CampusCardRecordMapper {
    int deleteByPrimaryKey(Integer campusCardRecordId);

    int insert(CampusCardRecord record);

    int insertSelective(CampusCardRecord record);

    CampusCardRecord selectByPrimaryKey(Integer campusCardRecordId);

    int updateByPrimaryKeySelective(CampusCardRecord record);

    int updateByPrimaryKey(CampusCardRecord record);
}