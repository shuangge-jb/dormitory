package com.dormitory.dao;

import com.dormitory.entity.CampusCard;

public interface CampusCardMapper {
    int deleteByPrimaryKey(Integer cardId);

    int insert(CampusCard record);

    int insertSelective(CampusCard record);

    CampusCard selectByPrimaryKey(Integer cardId);

    int updateByPrimaryKeySelective(CampusCard record);

    int updateByPrimaryKey(CampusCard record);
}