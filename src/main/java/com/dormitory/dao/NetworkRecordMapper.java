package com.dormitory.dao;

import com.dormitory.entity.NetworkRecord;

public interface NetworkRecordMapper {
    int deleteByPrimaryKey(Integer networkRecordId);

    int insert(NetworkRecord record);

    int insertSelective(NetworkRecord record);

    NetworkRecord selectByPrimaryKey(Integer networkRecordId);

    int updateByPrimaryKeySelective(NetworkRecord record);

    int updateByPrimaryKey(NetworkRecord record);
}