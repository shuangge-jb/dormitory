package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Paramater;

public interface ParamaterDAO {
	@Insert(" insert into paramater(paramater_name,description,type,interface_id) "
			+ " values(#{paramaterName},#{description},#{type},#{interfaceId}) ")
	@Options(useGeneratedKeys = true, keyProperty = "paramaterId")
	void save(Paramater item);

	@Select(" select * from paramater where paramater_id=#{paramaterId} ")
	@ResultMap("com.dormitory.mapper.ParamaterMapper.paramater")
	Paramater get(@Param("paramaterId") Integer paramaterId);

	@Update(" update paramater set paramater_name=#{paramaterName} ,"
			+ "description=#{description},type=#{type} where paramater_id=#{paramaterId} ")
	void update(Paramater item);

	@Delete(" delete from paramater where paramater_id=#{paramaterId}")
	void remove(@Param("paramaterId") Integer paramaterId);

	@Select("select LAST_INSERT_ID()")
	Integer getLastInsertId();

	@Select(" select * from paramater where interface_id=#{interfaceId} limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.ParamaterMapper.paramater")
	List<Paramater> listByInterfaceId(@Param("interfaceId") Integer interfaceId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);

	@Select("select count(*) from paramater where interface_id=#{interfaceId}  ")
	Integer getSizeByInterfaceId(@Param("interfaceId") Integer interfaceId);

	@Select(" select * from paramater where interface_id=#{interfaceId} and paramater_name=#{paramName} ")
	@ResultMap("com.dormitory.mapper.ParamaterMapper.paramater")
	List<Paramater> listByParamName(@Param("interfaceId") Integer interfaceId, @Param("paramName") String paramName);
}
