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
	@Select(" select * from lost_found order by create_time desc limit #{start},#{pageSize}")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public List<LostFound> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select(" select count(*) from lost_found ")
	public Integer getSize();

	@Select(" select * from lost_found order by create_time desc limit #{n}")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public List<LostFound> listLimit(@Param("n") Integer n);

	@Select(" select * from lost_found where student_id=#{studentId} order by create_time desc #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public List<LostFound> listByStudentId(@Param("studentId") Long studentId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);

	@Select(" select count(*) from lost_found where student_id=#{studentId} ")
	public Integer getSizeByStudentId(@Param("studentId") Long studentId);

	@Select("select l.* from lost_found l join student s on l.student_id=s.student_id "
			+ " join dormitory d on d.dormitory_id=s.dormitory_id "
			+ " where d.building_id=#{buildingId} limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public List<LostFound> listByBuildingId(@Param("buildingId") Integer buildingId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);

	@Select("select count(l.*) from lost_found l join student s on l.student_id=s.student_id "
			+ " join dormitory d on d.dormitory_id=s.dormitory_id where d.building_id=#{buildingId} ")
	public Integer getSizeByBuildingId(@Param("buildingId") Integer buildingId);

	@Select(" select * from lost_found where lost_found_id=#{lostFoundId} ")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public LostFound get(@Param("lostFoundId") Integer lostFoundId);

	@Select(" select LAST_INSERT_ID() ")
	public Integer getLastInsertId();

	@Insert(" insert into lost_found(student_id,content,create_time,state,publisher,place)  "
			+ " values(#{studentId},#{content},#{createTime},#{state},#{publisher},#{place}) ")
	@Options(useGeneratedKeys = true, keyProperty = "lostFoundId")
	public void save(LostFound lostFound);

	@Update(" update lost_found  set student_id=#{studentId},content=#{content}, "
			+ " create_time=#{createTime},state=#{state},publisher=#{publisher},place=#{place} "
			+ " where lost_found_id=#{lostFoundId} ")
	public void update(LostFound lostFound);

	@Update(" update lost_found  set state=0 where lost_found_id=#{lostFoundId} ")
	public void remove(@Param("lostFoundId") Integer lostFoundId);

}