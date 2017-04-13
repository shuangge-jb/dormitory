package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.LostFound;

public interface LostFoundDAO {
	@Select(" select * from lost_found order by create_time desc ")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public List<LostFound> list();

	@Select(" select * from lost_found order by create_time desc limit #{n}")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public List<LostFound> listLimit(@Param("n") Integer n);

	@Select(" select * from lost_found where student_id=#{studentId} order by create_time desc ")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public List<LostFound> listByStudentId(@Param("studentId") Long studentId);

	@Select(" select * from lost_found where lost_found_id=#{lostFoundId} ")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public LostFound get(@Param("lostFoundId") Integer lostFoundId);

	@Select(" select LAST_INSERT_ID() ")
	public Integer getLastInsertId();

	@Insert(" insert into lost_found(student_id,content,create_time,state)  "
			+ " values(#{studentId},#{content},#{createTime},#{state}) ")
	@Options(useGeneratedKeys = true, keyProperty = "lostFoundId")
	public void save(LostFound lostFound);

	@Update(" update lost_found  set student_id=#{studentId},content=#{content}, "
			+ " create_time=#{createTime} "
			+ " where lost_found_id=#{lostFoundId} ")
	public void update(LostFound lostFound);

	@Update(" update lost_found  set state=0 "
			+ " where lost_found_id=#{lostFoundId} ")
	public void remove(@Param("lostFoundId") Integer lostFoundId);

}