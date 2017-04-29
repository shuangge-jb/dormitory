package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.dormitory.dao.sql.SQLProvider;
import com.dormitory.entity.Postcard;

public interface PostcardDAO {
	@Select("select * from postcard order by create_time desc limit #{n} ")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcard")
	public List<Postcard> listLimit(@Param("n") Integer n);

	@Select("select * from postcard order by create_time desc limit (pageIndex-1)*pageSize,pageSize ")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcard")
	public List<Postcard> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

	@Select(" select * from postcard where student_id=#{studentId} order by create_time desc limit (pageIndex-1)*pageSize,pageSize ")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcard")
	public List<Postcard> listByStudentId(@Param("studentId") Long studentId,@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

	@Select(" select * from postcard where postcard_id=#{postcardId} ")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcard")
	public Postcard get(@Param("postcardId") Integer postcardId);

	@Select(" select LAST_INSERT_ID() ")
	public Integer getLastInsertId();

	@Insert(" insert into postcard(student_id,dormitory_id,create_time,state) "
			+ " values(#{studentId},#{dormitoryId},#{createTime},#{state}) ")
	@Options(useGeneratedKeys = true, keyProperty = "postcardId")
	public void save(Postcard postcard);

	@Update(" update postcard " + " set student_id=#{studentId},dormitory_id=#{dormitoryId}, "
			+ " create_time=#{createTime} " + " where postcard_id=#{postcardId} ")
	public void update(Postcard postcard);

	@Update(" update postcard " + " set state=0 " + " where postcard_id=#{postcardId} ")
	public void remove(Integer postcardId);
}
