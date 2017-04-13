package com.dormitory.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.dormitory.entity.Network;

public interface NetworkDAO {
   
	@Select("select * from network n  where n.student_id=#{0} ")
	@ResultMap("com.dormitory.mapper.NetworkMapper.network")
    Network getNetwork(Long studentId);

}