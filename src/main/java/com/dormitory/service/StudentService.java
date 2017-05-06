package com.dormitory.service;

import java.util.List;

import com.dormitory.dto.student.StudentDTO;
import com.dormitory.entity.Student;

public interface StudentService
		extends GetService<Student, Long>, SaveOrUpdateService<Student> {
	List<Student> listByBuildingId(Integer buildingId, Integer pageIndex, Integer pageSize);

	Integer getSizeByBuildingId(Integer buildingId);
	
	void remove(Long studentId);
}
