package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.dormitory.dao.sql.SQLProvider;
import com.dormitory.dto.PostcardDTO;
import com.dormitory.entity.Postcard;

public interface PostcardDAO {
	@Select(" select p.postcard_id,p.name ,b.building_name,p.create_time,p.state " + " from postcard p "
			+ " join building b on p.building_id=b.building_id " + " order by p.create_time desc limit #{n} ")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcard")
	public List<PostcardDTO> listLimit(@Param("n") Integer n);

	@Select(" select p.postcard_id,p.name ,b.building_name,p.create_time,p.state " + " from postcard p "
			+ " join building b on p.building_id=b.building_id "
			+ " order by p.create_time desc limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcardDTO")
	public List<PostcardDTO> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select("select count(*) from postcard ")
	public Integer getSize();

	@Select(" select p.postcard_id,p.name ,b.building_name,p.create_time,p.state "
			+ " from postcard p join building b on p.building_id=b.building_id " + " where p.building_id=#{buildingId} "
			+ " order by p.create_time desc limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcardDTO")
	public List<PostcardDTO> listByBuildingId(@Param("buildingId") Integer buildingId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);

	@Select(" select count(*) from postcard p where p.building_id=#{buildingId} ")
	public Integer getSizeByBuildingId(@Param("buildingId") Integer buildingId);

	@Select(" select p.* from postcard p " + " where p.postcard_id=#{postcardId} ")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcard")
	public Postcard get(@Param("postcardId") Integer postcardId);

	@Select(" select LAST_INSERT_ID() ")
	public Integer getLastInsertId();

	@Insert(" insert into postcard(name,building_id,create_time,state) "
			+ " values(#{name},#{buildingId},#{createTime},#{state}) ")
	@Options(useGeneratedKeys = true, keyProperty = "postcardId")
	public void save(Postcard postcard);

	@Update(" update postcard set name=#{name},building_id=#{buildingId}, "
			+ " create_time=#{createTime},state=#{state} where postcard_id=#{postcardId} ")
	public void update(Postcard postcard);

	@Update(" update postcard set state=1 where postcard_id=#{postcardId} ")
	public void changeState(@Param("postcardId") Integer postcardId);

	@Delete(" delete from postcard where postcard_id=#{postcardId} ")
	public void remove(@Param("postcardId") Integer postcardId);
}
