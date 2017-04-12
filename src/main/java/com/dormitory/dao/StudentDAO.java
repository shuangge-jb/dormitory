package com.dormitory.dao;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import com.dormitory.entity.Student;

public interface StudentDAO {
    
	@Select("select * from student where student_id=#{0}")
	@ResultMap("com.dormitory.mapper.StudentMapper.student")
    Student getStudent(Long studentId);

   
}