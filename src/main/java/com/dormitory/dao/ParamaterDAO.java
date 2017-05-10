package com.dormitory.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.dto.ParamaterDTO;
import com.dormitory.entity.Interface;
import com.dormitory.entity.Paramater;

public interface ParamaterDAO {
	@Insert(" insert into paramater(paramater_name,description,type,interface_id,device_id) "
			+ " values(#{paramaterName},#{description},#{type},#{interfaceId},#{deviceId}) ")
	@Options(useGeneratedKeys = true, keyProperty = "paramaterId")
	void save(Paramater item);

	@Select(" select * from paramater where paramater_id=#{paramaterId} ")
	@ResultMap("com.dormitory.mapper.ParamaterMapper.paramater")
	Paramater get(@Param("paramaterId") Integer paramaterId);

	@Update(" update paramater set paramater_name=#{paramaterName} ,"
			+ "description=#{description},type=#{type},interface_id=#{interfaceId}, "
			+ " device_id=#{deviceId} where paramater_id=#{paramaterId} ")
	void update(Paramater item);

	@Delete(" delete from paramater where paramater_id=#{paramaterId}")
	void remove(@Param("paramaterId") Integer paramaterId);

	@Delete("delete from paramater where interface_id=#{interfaceId}")
	void removeByInterfaceId(@Param("interfaceId") Integer interfaceId);

	@Delete("delete from paramater where device_id=#{deviceId}")
	void removeByDeviceId(@Param("deviceId") Long deviceId);

	@Select("select LAST_INSERT_ID()")
	Integer getLastInsertId();

	@Select("select p.*,i.interface_name,d.name as device_name "
			+ " from paramater p join interface i on p.interface_id=i.interface_id join device d on p.device_id=d.device_id "
			+ " where p.interface_id=#{interfaceId} limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.ParamaterMapper.paramaterDTO")
	List<ParamaterDTO> listByInterfaceId(@Param("interfaceId") Integer interfaceId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);
	@Select("select p.*,i.interface_name,d.name as device_name "
			+ " from paramater p join interface i on p.interface_id=i.interface_id join device d on p.device_id=d.device_id "
			+ " where p.interface_id=#{interfaceId}")
	@ResultMap("com.dormitory.mapper.ParamaterMapper.paramaterDTO")
	List<ParamaterDTO> listByInterfaceIdAll(@Param("interfaceId") Integer interfaceId);
	@Select("select count(*) from paramater where interface_id=#{interfaceId}  ")
	Integer getSizeByInterfaceId(@Param("interfaceId") Integer interfaceId);

	@Select(" select * from paramater where interface_id=#{interfaceId} and paramater_name=#{paramName} ")
	@ResultMap("com.dormitory.mapper.ParamaterMapper.paramater")
	List<Paramater> listByParamName(@Param("interfaceId") Integer interfaceId, @Param("paramName") String paramName);

	@Select(" select p.*,i.interface_name,d.name as device_name "
			+ " from paramater p join interface i on p.interface_id=i.interface_id join device d on p.device_id=d.device_id "
			+ " limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.ParamaterMapper.paramaterDTO")
	List<ParamaterDTO> listAll(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
	@Select(" select count(*)"
			+ " from paramater p join interface i on p.interface_id=i.interface_id join device d on p.device_id=d.device_id "
			)
Integer getAllSize();
}
