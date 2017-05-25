package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.dto.master.LostFoundDTO;
import com.dormitory.entity.LostFound;

public interface LostFoundDAO {
	@Select(" select l.lost_found_id,l.student_id,l.content,l.create_time,l.state,m.name,l.place,l.img_path "
			+ " from lost_found l join master m on l.publisher_id=m.master_id order by create_time desc limit #{start},#{pageSize}")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFoundDTO")
	public List<LostFoundDTO> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select(" select count(*) from lost_found ")
	public Integer getSize();

	@Select(" select * from lost_found order by create_time desc limit #{n}")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public List<LostFound> listLimit(@Param("n") Integer n);

	@Select(" select * from lost_found where student_id=#{studentId} order by create_time desc #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFoundDTO")
	public List<LostFoundDTO> listByStudentId(@Param("studentId") Long studentId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);

	@Select(" select count(*) from lost_found where student_id=#{studentId} ")
	public Integer getSizeByStudentId(@Param("studentId") Long studentId);

	@Select(" select l.lost_found_id,l.student_id,l.content,l.create_time,l.state,m.name,l.place,l.img_path "
			+ " from lost_found l join master m on l.publisher_id=m.master_id "
			+ "where m.building_id=#{buildingId} limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFoundDTO")
	public List<LostFoundDTO> listByBuildingId(@Param("buildingId") Integer buildingId, @Param("start") Integer start,
			@Param("pageSize") Integer pageSize);

	@Select("select count(*) from lost_found l join master m on l.publisher_id=m.master_id "
			+ "where m.building_id=#{buildingId} ")
	public Integer getSizeByBuildingId(@Param("buildingId") Integer buildingId);

	@Select(" select * from lost_found where lost_found_id=#{lostFoundId} ")
	@ResultMap("com.dormitory.mapper.LostFoundMapper.lostFound")
	public LostFound get(@Param("lostFoundId") Integer lostFoundId);

	@Select(" select LAST_INSERT_ID() ")
	public Integer getLastInsertId();

	@Insert(" insert into lost_found(student_id,content,create_time,state,publisher_id,place,img_path)  "
			+ " values(#{studentId},#{content},#{createTime},#{state},#{publisherId},#{place},#{imgPath}) ")
	@Options(useGeneratedKeys = true, keyProperty = "lostFoundId")
	public void save(LostFound lostFound);

	@Update(" update lost_found  set student_id=#{studentId},content=#{content},create_time=#{createTime}, "
			+ " state=#{state},publisher_id=#{publisherId},place=#{place},img_path=#{imgPath} "
			+ " where lost_found_id=#{lostFoundId} ")
	public void update(LostFound lostFound);

	@Delete("delete from lost_found where lost_found_id=#{lostFoundId} ")
	public void remove(@Param("lostFoundId") Integer lostFoundId);

	@Update("update lost_found set state=1 where lost_found_id=#{lostFoundId} ")
	public void changeState(@Param("lostFoundId") Integer lostFoundId);

}