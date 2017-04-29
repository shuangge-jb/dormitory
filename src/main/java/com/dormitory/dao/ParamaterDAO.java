package com.dormitory.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Paramater;

public interface ParamaterDAO {
	@Insert(" insert into paramater(paramater_name,interface_id) values(#{paramaterName},#{interfaceId}) ")
	@Options(useGeneratedKeys = true, keyProperty = "paramaterId")
	void save(Paramater item);

	@Select(" select * from paramater where paramater_id=#{paramaterId} ")
	@ResultMap("com.dormitory.mapper.ParamaterMapper.paramater")
	Paramater get(@Param("paramaterId") Integer paramaterId);

	@Update(" update paramater set paramater_name=#{paramaterName} where paramater_id=#{paramaterId} ")
	void update(Paramater item);

	@Delete(" delete from paramater where paramater_id=#{paramaterId}")
	void remove(@Param("paramaterId") Integer paramaterId);

	@Select("select LAST_INSERT_ID()")
	Integer getLastInsertId();
}
