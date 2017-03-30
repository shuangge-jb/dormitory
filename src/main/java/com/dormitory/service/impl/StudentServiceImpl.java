package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.StudentDAO;
import com.dormitory.entity.Student;
import com.dormitory.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDAO studentDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dormitory.service.StudentService#getStudent(java.lang.Long)
	 */
	@Override
	public Student getStudent(Long studentId) {

		return studentDAO.getStudent(studentId);
	}

	/**
	 * @return the studentDAO
	 */
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	/**
	 * @param studentDAO the studentDAO to set
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	

}
