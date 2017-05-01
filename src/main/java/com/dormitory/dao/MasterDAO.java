package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Master;

public interface MasterDAO {
	@Select("select * from master where master_id=#{masterId}")
	@ResultMap("com.dormitory.mapper.MasterMapper.master")
	public Master get(@Param("masterId") Integer id);

	@Select("select LAST_INSERT_ID()")
	public Integer getLastInsertId();

	@Insert(" insert into master(name,phone_number,email,password) "
			+ " values(#{name},#{phoneNumber},#{email},#{password})")
	@Options(useGeneratedKeys = true, keyProperty = "masterId")
	public void save(Master master);

	@Update("update master set name=#{name},phone_number=#{phoneNumber}, " + " email=#{email},password=#{password}")
	public void update(Master master);

	@Delete("delete from master where master=#{masterId}")
	public void remove(Master master);

	@Select("select * from master limit #{start},#{pageSize}")
	@ResultMap("com.dormitory.mapper.MasterMapper.master")
	public List<Master> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select("select count(*) from master ")
	public Integer getSize();
}
