package com.dormitory.dao;

import com.dormitory.entity.WaterRecord;

public interface WaterRecordMapper {
    int deleteByPrimaryKey(Integer waterRecordId);

    int insert(WaterRecord record);

    int insertSelective(WaterRecord record);

    WaterRecord selectByPrimaryKey(Integer waterRecordId);

    int updateByPrimaryKeySelective(WaterRecord record);

    int updateByPrimaryKey(WaterRecord record);
}