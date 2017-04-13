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
	@SelectProvider(type = SQLProvider.class, method = "listPostcard")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcard")
	public List<Postcard> listPostcard(Integer n);

	@Select(" select * from postcard where student_id=#{studentId} order by create_time desc ")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcard")
	public List<Postcard> listPostcardByStudentId(
			@Param("studentId") Long studentId);

	@Select(" select * from postcard where postcard_id=#{postcardId} ")
	@ResultMap("com.dormitory.mapper.PostcardMapper.postcard")
	public Postcard getPostcard(@Param("postcardId") Integer postcardId);
	@Select(" select LAST_INSERT_ID() ")
	public Integer getLastInsertId();

	@Insert(" insert into postcard(student_id,dormitory_id,create_time,state) "
			+ " values(#{studentId},#{dormitoryId},#{createTime},#{state}) ")
	@Options(useGeneratedKeys = true, keyProperty = "postcardId")
	public void savePostcard(Postcard postcard);

	@Update(" update postcard "
			+ " set dormitory_id=#{dormitoryId}, "
			+ " create_time=#{createTime} "
			+" where postcard_id=#{postcardId} ")
	public void updatePostcard(Postcard postcard);
	@Update(" update postcard "
			+" set state=0 "
			+" where postcard_id=#{postcardId} ")
	public void removePostcard(Integer postcardId);
}

