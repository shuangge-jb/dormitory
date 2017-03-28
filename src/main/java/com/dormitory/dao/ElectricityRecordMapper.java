package com.dormitory.dao;

import com.dormitory.entity.ElectricityRecord;

public interface ElectricityRecordMapper {
    int deleteByPrimaryKey(Integer electricityRecordId);

    int insert(ElectricityRecord record);

    int insertSelective(ElectricityRecord record);

    ElectricityRecord selectByPrimaryKey(Integer electricityRecordId);

    int updateByPrimaryKeySelective(ElectricityRecord record);

    int updateByPrimaryKey(ElectricityRecord record);
}