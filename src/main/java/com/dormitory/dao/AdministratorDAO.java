package com.dormitory.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Administrator;

public interface AdministratorDAO {
	@Select("select * from administrator where administrator_id=#{administratorId}")
	@ResultMap("com.dormitory.mapper.AdministratorMapper.administrator")
	public Administrator get(@Param("administratorId") Integer id);

	@Select("select LAST_INSERT_ID()")
	public Integer getLastInsertId();

	@Insert(" insert into administrator(name,phone_number,email,password) "
			+ " values(#{name},#{phoneNumber},#{email},#{password})")
	@Options(useGeneratedKeys = true, keyProperty = "administratorId")
	public void save(Administrator administrator);

	@Update("update administrator set name=#{name},#{phoneNumber},#{email},#{password}")
	public void update(Administrator administrator);

	@Delete("delete from administrator where administrator_id=#{administratorId}")
	public void remove(Administrator administrator);
}
