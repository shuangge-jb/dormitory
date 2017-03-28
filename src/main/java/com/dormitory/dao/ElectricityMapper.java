package com.dormitory.dao;

import com.dormitory.entity.Electricity;

public interface ElectricityMapper {
    int deleteByPrimaryKey(Integer dormitoryId);

    int insert(Electricity record);

    int insertSelective(Electricity record);

    Electricity selectByPrimaryKey(Integer dormitoryId);

    int updateByPrimaryKeySelective(Electricity record);

    int updateByPrimaryKey(Electricity record);
}