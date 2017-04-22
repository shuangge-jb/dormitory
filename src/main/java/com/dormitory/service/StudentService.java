package com.dormitory.service;

import com.dormitory.entity.Student;
import com.dormitory.service.dto.RegisterDTO;

public interface StudentService extends GetService<Student, Long>,SaveOrUpdateService<Student>,RemoveService<Student> {
	public String saveOrUpdate(RegisterDTO registerDTO);
}
