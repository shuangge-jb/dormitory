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

	@Insert(" insert into device(dormitory_id,student_id,name,type,state,path) "
			+ " values(#{dormitoryId},#{studentId},#{name},#{type},#{state},#{path}) ")
	@Options(useGeneratedKeys = true, keyProperty = "deviceId")
	public void save(Device device);

	@Update(" update device set dormitory_id=#{dormitoryId},student_id=#{studentId}, "
			+ " name=#{name},type=#{type},state=#{state},path=#{path} ")
	public void update(Device device);

	@Delete("delete from device where device_id=#{deviceId}")
	public void remove(Device device);

	@Select(" select * from device where dormitory_id=#{dormitoryId} limit (pageIndex-1)*pageSize,pageSize")
	@ResultMap("com.dormitory.mapper.DeviceMapper.device")
	public List<Device> listByDormitoryId(@Param("dormitoryId") Integer dormitoryId,
			@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

	@Select(" select count(*) from device where dormitory_id=#{dormitoryId}")
	public Integer getSizeByDormitory(@Param("dormitoryId") Integer dormitoryId);
}
