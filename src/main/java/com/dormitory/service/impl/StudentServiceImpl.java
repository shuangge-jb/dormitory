package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.BuildingDAO;
import com.dormitory.dao.DormitoryDAO;
import com.dormitory.dao.StudentDAO;
import com.dormitory.dto.student.StudentDTO;
import com.dormitory.entity.Building;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.entity.User;
import com.dormitory.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Resource
	private StudentDAO studentDAO;
	@Resource
	private DormitoryDAO dormitoryDAO;
	@Resource
	private BuildingDAO buildingDAO;

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
	public void remove(Long studentId) {
		studentDAO.remove(studentId);
	}

	@Override
	public Long getLastInsertId() {
		return studentDAO.getLastInsertId();
	}

	@Override
	public List<StudentDTO> listByBuildingId(Integer buildingId, Integer pageIndex, Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		return studentDAO.listByBuildingId(buildingId, start, pageSize);
	}

	@Override
	public Integer getSizeByBuildingId(Integer buildingId) {
		return studentDAO.getSizeByBuildingId();
	}

}
