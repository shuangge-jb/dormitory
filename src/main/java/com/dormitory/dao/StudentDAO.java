package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.Student;

public interface StudentDAO {

	@Select("select * from student where student_id=#{0}")
	@ResultMap("com.dormitory.mapper.StudentMapper.student")
	Student get(Long studentId);

	@Update(" update student set password=#{password} where student_id=#{studentId} ")
	@ResultMap("com.dormitory.mapper.StudentMapper.student")
	void updatePassword(Student student);

	@Insert(" insert into student(student_id,dormitory_id,bed_id,name,phone_number,email,password,img_path) "
			+ " values(#{studentId},#{dormitoryId},#{bedId},#{name},#{phoneNumber},#{email},#{password},#{imgPath}) ")
	@Options(useGeneratedKeys = true, keyProperty = "studentId")
	void save(Student student);

	@Update(" update student set dormitory_id=#{dormitoryId},bed_id=#{bedId},"
			+ " out_date=#{outDate},validate_code=#{validateCode}, img_path=#{imgPath},"
			+ " phone_number=#{phoneNumber},email=#{email},password=#{password} where student_id=#{studentId}")
	void update(Student student);

	@Delete(" delete from student where student_id=#{studentId} ")
	void remove(Student student);

	@Select(" select LAST_INSERT_ID() ")
	Long getLastInsertId();

	@Select("select * from student limit #{start},#{pageSize}")
	@ResultMap("com.dormitory.mapper.StudentMapper.student")
	public List<Student> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select("select count(*) from student ")
	public Integer getSize();

	@Select("select s.* from student s join dormitory d on s.dormitory_id=d.dormitory_id "
			+ " where d.building_id=#{buildingId} limit #{start},#{pageSize}")
	@ResultMap("com.dormitory.mapper.StudentMapper.student")
	public List<Student> listByBuildingId(@Param("buildingId") Integer buildingId,
			@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select("select count(s.*) from student s join dormitory d on s.dormitory_id=d.dormitory_id "
			+ " where d.building_id=#{buildingId} ")
	public Integer getSizeByBuildingId();
}