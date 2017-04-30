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
	@Select("select * from deivce where device_id=#{deviceId} ")
	@ResultMap("com.dormitory.mapper.DeviceMapper.device")
	public Device get(@Param("deviceId") Long deviceId);

	@Select("select LAST_INSERT_ID()")
	public Long getLastInsertId();

	@Insert(" insert into device(name,img_path,description,model_path) "
			+ " values(#{name},#{imgPath},#{description},#{model_path}) ")
	@Options(useGeneratedKeys = true, keyProperty = "deviceId")
	public void save(Device device);

	@Update(" update device set  "
			+ " name=#{name},img_path=#{imgPath},description=#{description},model_path=#{modelPath} ")
	public void update(Device device);

	@Delete("delete from device where device_id=#{deviceId}")
	public void remove(Device device);

	@Select("select * from device limit (pageIndex-1)*pageSize,pageSize")
	@ResultMap("com.dormitory.mapper.DeviceMapper.device")
	public List<Device> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

	@Select("select count(*) from device limit ")
	public Integer getSize();
}
