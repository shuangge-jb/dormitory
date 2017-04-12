package com.dormitory.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.dormitory.entity.NetworkRecord;

public interface NetworkRecordDAO {
   
	@Select("select * from network_record r "
			+ " where  r.student_id=#{0}")
	@ResultMap("com.dormitory.mapper.NetworkRecordMapper.networkRecord")
    List<NetworkRecord> listNetworkRecord(Long studentId);

    
}