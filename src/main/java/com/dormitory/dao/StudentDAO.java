package com.dormitory.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
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

	@Insert(" insert into student(student_id,dormitory_id,bed_id,name,phone_number,email,password) "
			+ " values(#{studentId},#{dormitoryId},#{bedId},#{name},#{phoneNumber},#{email},#{password}) ")
	@Options(useGeneratedKeys = true, keyProperty = "studentId")
	void save(Student student);

	@Update(" update student set dormitory_id=#{dormitoryId},bed_id=#{bedId}, "
			+ " phone_number=#{phoneNumber},email=#{email},password=#{password} ")
	void update(Student student);

	@Delete(" delete from student where student_id=#{studentId} ")
	void remove(Student student);

	@Select(" select LAST_INSERT_ID() ")
	Long getLastInsertId();
}