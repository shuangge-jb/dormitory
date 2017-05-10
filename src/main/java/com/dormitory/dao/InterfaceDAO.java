package com.dormitory.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Device;
import com.dormitory.entity.Interface;

public interface InterfaceDAO {
	@Insert(" insert into interface(interface_name,interface_url,description,source,device_id,method,state) "
			+ " values(#{interfaceName},#{interfaceUrl},#{description},#{source},#{deviceId},#{method},1) ")
	@Options(useGeneratedKeys = true, keyProperty = "interfaceId")
	void save(Interface item);

	@Select(" select * from interface where interface_id=#{interfaceId} ")
	@ResultMap("com.dormitory.mapper.InterfaceMapper.interface")
	Interface get(@Param("interfaceId") Integer interfaceId);

	@Update(" update interface set interface_name=#{interfaceName}, "
			+ " interface_url=#{interfaceUrl},description=#{description}, "
			+ " source=#{source},method=#{method},device_id=#{deviceId},state=#{state} where interface_id=#{interfaceId} ")
	void update(Interface item);

	@Delete(" delete from interface where interface_id=#{interfaceId} ")
	void remove(@Param("interfaceId") Integer interfaceId);

	@Delete("delete from interface where device_id=#{deviceId}")
	void removeByDeviceId(@Param("deviceId") Long deviceId);

	@Select("select LAST_INSERT_ID()")
	Integer getLastInsertId();

	/**
	 * 找出该设备所有的功能，包括不可用的，给管理员使用
	 * 
	 * @param deviceId
	 * @param start
	 * @param pageSize
	 * @return
	 */
	@Select("select * from interface where device_id=#{deviceId} limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.InterfaceMapper.interface")
	List<Interface> listByDeviceId(@Param("deviceId") Long deviceId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);

	@Select("select count(*) from interface where device_id=#{deviceId} ")
	Integer getSizeByDeviceId(@Param("deviceId") Long deviceId);

	@Select("select interface_id,interface_name from interface where device_id=#{deviceId}")
	@ResultMap("com.dormitory.mapper.InterfaceMapper.listByDeviceId")
	List<Map<String, String>> listByDeviceIdJSON(@Param("deviceId") Long deviceId);

	@Select("select i.* from interface i where i.device_id =#{deviceId} and i.interface_name=#{interfaceName}")
	@ResultMap("com.dormitory.mapper.InterfaceMapper.interface")
	List<Interface> listByInterfaceName(@Param("deviceId") Long deviceId, @Param("interfaceName") String interfaceName);

	/**
	 * 模糊搜索设备的功能，供学生调用
	 * 
	 * @param keyword
	 *            
	 * @param start
	 * @param pageSize
	 * @return
	 */
	@Select("select * from interface where device_id=#{deviceId} and interface_name like '%${keyword}%' and state=1  limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.InterfaceMapper.interface")
	List<Interface> listLike(@Param("deviceId") Long deviceId,@Param("keyword") String keyword,
			@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select("select count(*) from interface where device_id=#{deviceId} and  interface_name like '%${keyword}%' and state=1 ")
	Integer getSizeLike(@Param("keyword") String keyword, @Param("deviceId") Long deviceId);

	/**
	 * 找出该设备所有可用的功能，给学生使用
	 * 
	 * @param deviceId
	 * @param start
	 * @param pageSize
	 * @return
	 */
	@Select("select * from interface where device_id=#{deviceId} and state=1 limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.InterfaceMapper.interface")
	List<Interface> listByDeviceIdValid(@Param("deviceId") Long deviceId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);

	@Select("select count(*) from interface where device_id=#{deviceId} and state=1 ")
	Integer getSizeByDeviceIdValid(@Param("deviceId") Long deviceId);

}
