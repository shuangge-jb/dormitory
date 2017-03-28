package com.dormitory.dao;

import com.dormitory.entity.Network;

public interface NetworkMapper {
    int deleteByPrimaryKey(Long sutdentId);

    int insert(Network record);

    int insertSelective(Network record);

    Network selectByPrimaryKey(Long sutdentId);

    int updateByPrimaryKeySelective(Network record);

    int updateByPrimaryKey(Network record);
}