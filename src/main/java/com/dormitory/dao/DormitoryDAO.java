package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Dormitory;

public interface DormitoryDAO {

	@Select("select * from dormitory where dormitory_id=#{0} ")
	@ResultMap("com.dormitory.mapper.DormitoryMapper.dormitory")
	Dormitory get(Integer dormitoryId);

	@Insert(" insert into dormitory(building_id,room) values(#{buildingId},#{room}) ")
	@Options(useGeneratedKeys = true, keyProperty = "dormitoryId")
	void save(Dormitory dormitory);
	@Update(" update dormitory set building_id=#{building},room=#{room} where dormitory_id=#{dormitoryId} ")
	void update(Dormitory dormitory);
	@Delete("delete from dormitory where dormitory_id=#{dormitoryId} ")
	void remove(Dormitory dormitory);
	@Select("select * from dormitory where building_id=#{buildingId} and room=#{room} ")
	@ResultMap("com.dormitory.mapper.DormitoryMapper.dormitory")
	Dormitory getByBuildingIdAndRoom(@Param(value="buildingId")Integer buildingId,@Param(value="room")String room);


}