package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.dto.master.MasterDTO;
import com.dormitory.entity.Master;

public interface MasterDAO {
	@Select("select * from master where master_id=#{masterId}")
	@ResultMap("com.dormitory.mapper.MasterMapper.master")
	public Master get(@Param("masterId") Integer id);

	@Select("select LAST_INSERT_ID()")
	public Integer getLastInsertId();

	@Insert(" insert into master(name,phone_number,email,password,building_id,id_card,entry_time) "
			+ " values(#{name},#{phoneNumber},#{email},#{password},#{buildingId},#{idCard},#{entryTime})")
	@Options(useGeneratedKeys = true, keyProperty = "masterId")
	public void save(Master master);

	@Update("update master set name=#{name},phone_number=#{phoneNumber},"
			+ " email=#{email},password=#{password},building_id=#{buildingId}, "
			+ " id_card=#{idCard},entry_time=#{entryTime} where master_id=#{masterId}")
	public void update(Master master);

	@Delete("delete from master where master_id=#{masterId}")
	public void remove(@Param("masterId") Integer masterId);

	@Select(" select m.master_id,m.name,m.phone_number,m.email,m.password,b.building_name,m.id_card,m.entry_time "
			+ " from master m join building b on m.building_id=b.building_id limit #{start},#{pageSize}")
	@ResultMap("com.dormitory.mapper.MasterMapper.masterDTO")
	public List<MasterDTO> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select("select count(*) from master ")
	public Integer getSize();

	@Update(" update master set password=#{password} where master_id=#{masterId}")
	public void updatePassword(Master master);
}
