package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.DormitoryDAO;
import com.dormitory.dao.StudentDAO;
import com.dormitory.dto.student.StudentRegisterDTO;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.entity.User;
import com.dormitory.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDAO studentDAO;
	@Resource
	DormitoryDAO dormitoryDAO;

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

	public String saveOrUpdate(StudentRegisterDTO registerDTO) {
		Student student = (Student) registerDTO;
		Student temp = studentDAO.get(student.getStudentId());
		if (temp == null) {
			Dormitory dormitory = registerDTO.getDormitory();
			List<Dormitory> list = dormitoryDAO.getByBuildingAndRoom(dormitory);
			if (list.isEmpty()) {
				dormitoryDAO.save(dormitory);
			} else {
				studentDAO.save(student);
			}
		}else{
			return "已注册";
		}
		return null;

	}

	@Transactional
	@Override
	public Student saveOrUpdate(Student student) {
		Student temp = studentDAO.get(student.getStudentId());
		if (temp == null) {
			studentDAO.save(student);
		} else {
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
