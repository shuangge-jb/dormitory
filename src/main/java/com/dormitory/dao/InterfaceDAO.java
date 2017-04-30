package com.dormitory.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Interface;

public interface InterfaceDAO {
	@Insert(" insert into interface(interface_name,interface_url) values(#{interfaceName},#{interfaceUrl}) ")
	@Options(useGeneratedKeys = true, keyProperty = "interfaceId")
	void save(Interface item);

	@Select(" select * from interface where interface_id=#{interfaceId} ")
	@ResultMap("com.dormitory.mapper.InterfaceMapper.interface")
	Interface get(Integer interfaceId);

	@Update(" update interface set interface_name=#{interfaceName}, "
			+ " interface_url=#{interfaceUrl} where interface_id=#{interfaceId} ")
	void update(Interface item);

	@Delete(" delete from interface where interface_id=#{interfaceId} ")
	void remove(Interface item);

	@Select("select LAST_INSERT_ID()")
	Integer getLastInsertId();
}