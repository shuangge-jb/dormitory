package com.dormitory.dao;

import com.dormitory.entity.Water;

public interface WaterMapper {
    int deleteByPrimaryKey(Integer dormitoryId);

    int insert(Water record);

    int insertSelective(Water record);

    Water selectByPrimaryKey(Integer dormitoryId);

    int updateByPrimaryKeySelective(Water record);

    int updateByPrimaryKey(Water record);
}