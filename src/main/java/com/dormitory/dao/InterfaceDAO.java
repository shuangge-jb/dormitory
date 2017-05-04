package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Interface;

public interface InterfaceDAO {
	@Insert(" insert into interface(interface_name,interface_url,description,source,device_id,method) "
			+ " values(#{interfaceName},#{interfaceUrl},#{description},#{source},#{deviceId},#{method}) ")
	@Options(useGeneratedKeys = true, keyProperty = "interfaceId")
	void save(Interface item);

	@Select(" select * from interface where interface_id=#{interfaceId} ")
	@ResultMap("com.dormitory.mapper.InterfaceMapper.interface")
	Interface get(@Param("interfaceId") Integer interfaceId);

	@Update(" update interface set interface_name=#{interfaceName}, "
			+ " interface_url=#{interfaceUrl},description=#{description}, "
			+ " source=#{source},method=#{method},device_id=#{deviceId} where interface_id=#{interfaceId} ")
	void update(Interface item);

	@Delete(" delete from interface where interface_id=#{interfaceId} ")
	void remove(Interface item);

	@Select("select LAST_INSERT_ID()")
	Integer getLastInsertId();

	@Select("select * from interface where device_id=#{deviceId} limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.InterfaceMapper.interface")
	List<Interface> listByDeviceId(@Param("deviceId") Long deviceId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);

	@Select("select count(*) from interface where device_id=#{deviceId} ")
	Integer getSizeByDeviceId(@Param("deviceId") Long deviceId);

	@Select("select i.* from interface i where i.device_id =#{deviceId} and i.interface_name=#{interfaceName}")
	@ResultMap("com.dormitory.mapper.InterfaceMapper.interface")
	List<Interface> listByInterfaceName(@Param("deviceId") Long deviceId, @Param("interfaceName") String interfaceName);
}
