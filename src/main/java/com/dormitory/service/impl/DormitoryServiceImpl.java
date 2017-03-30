package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.DormitoryDAO;
import com.dormitory.dao.StudentDAO;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.service.DormitoryService;
import com.dormitory.service.StudentService;
@Service
public class DormitoryServiceImpl implements DormitoryService {
@Resource
private DormitoryDAO dormitoryDAO;
@Resource
private StudentDAO studentDAO;
	/* (non-Javadoc)
	 * @see com.dormitory.service.DormitoryService#getDormitory(java.lang.String, java.lang.String)
	 */
	@Override
	public Dormitory getDormitory(Long studentId) {
		Student student=studentDAO.getStudent(studentId);
		return getDormitory(student.getDormitoryId());
	}
	
	/* (non-Javadoc)
	 * @see com.dormitory.service.DormitoryService#getDormitory(java.lang.Integer)
	 */
	@Override
	public Dormitory getDormitory(Integer dormitoryId) {
		return dormitoryDAO.getDormitory(dormitoryId);
	}

	/**
	 * @return the dormitoryDAO
	 */
	public DormitoryDAO getDormitoryDAO() {
		return dormitoryDAO;
	}
	/**
	 * @param dormitoryDAO the dormitoryDAO to set
	 */
	public void setDormitoryDAO(DormitoryDAO dormitoryDAO) {
		this.dormitoryDAO = dormitoryDAO;
	}
	

	
}
