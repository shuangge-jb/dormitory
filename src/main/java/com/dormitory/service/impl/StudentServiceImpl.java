package com.dormitory.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.StudentDAO;
import com.dormitory.entity.Student;
import com.dormitory.entity.User;
import com.dormitory.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDAO studentDAO;

	@Override
	public Student get(Long studentId) {

		return studentDAO.get(studentId);
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	
	@Transactional
	@Override
	public Student saveOrUpdate(Student student) {
		Student temp=studentDAO.get(student.getStudentId());
		if(temp==null){
			studentDAO.save(student);
		}else{
			studentDAO.update(student);
		}
		return null;
	}
	@Transactional
	@Override
	public Student remove(Student student) {
		studentDAO.remove(student);
		return student;
	}

	@Override
	public Long getLastInsertId() {
		return studentDAO.getLastInsertId();
	}

}
