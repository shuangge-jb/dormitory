package com.dormitory.service;

import com.dormitory.entity.Student;

public interface StudentService {
	public Student getStudent(Long studentId);
	
	public Student updatePassword(Student student);
}
