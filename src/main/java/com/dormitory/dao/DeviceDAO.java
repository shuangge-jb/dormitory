package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Device;

public interface DeviceDAO {
	@Select("select * from device where device_id=#{deviceId} ")
	@ResultMap("com.dormitory.mapper.DeviceMapper.device")
	public Device get(@Param("deviceId") Long deviceId);
	@Select("select * from device where name=#{deviceName} ")
	@ResultMap("com.dormitory.mapper.DeviceMapper.device")
	public List<Device> getByName(@Param("deviceName")String deviceName); 

	@Select("select LAST_INSERT_ID()")
	public Long getLastInsertId();

	@Insert(" insert into device(name,type,img_path,description,model_path) "
			+ " values(#{name},#{type},#{imgPath},#{description},#{modelPath}) ")
	@Options(useGeneratedKeys = true, keyProperty = "deviceId")
	public void save(Device device);

	@Update(" update device set  "
			+ " name=#{name},type=#{type},img_path=#{imgPath},description=#{description},model_path=#{modelPath} ")
	public void update(Device device);

	@Delete("delete from device where device_id=#{deviceId}")
	public void remove(Device device);

	@Select("select * from device limit #{start},#{pageSize}")
	@ResultMap("com.dormitory.mapper.DeviceMapper.device")
	public List<Device> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select("select count(*) from device ")
	public Long getSize();
}
