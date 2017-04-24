package com.dormitory.service;

import com.dormitory.dto.student.StudentRegisterDTO;
import com.dormitory.entity.Student;

public interface StudentService extends GetService<Student, Long>,SaveOrUpdateService<Student>,RemoveService<Student> {
	public String saveOrUpdate(StudentRegisterDTO registerDTO);
}
