package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.StudentDAO;
import com.dormitory.entity.Student;
import com.dormitory.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDAO studentMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dormitory.service.StudentService#getStudent(java.lang.Long)
	 */
	@Override
	public Student getStudent(Long studentId) {

		return studentMapper.getStudent(studentId);
	}

	/**
	 * @return the studentMapper
	 */
	public StudentDAO getStudentMapper() {
		return studentMapper;
	}

	/**
	 * @param studentMapper
	 *            the studentMapper to set
	 */
	public void setStudentMapper(StudentDAO studentMapper) {
		this.studentMapper = studentMapper;
	}

}
