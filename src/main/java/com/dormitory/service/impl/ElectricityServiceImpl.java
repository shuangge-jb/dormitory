package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.DormitoryDAO;
import com.dormitory.dao.ElectricityDAO;
import com.dormitory.dao.StudentDAO;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Electricity;
import com.dormitory.service.ElectricityService;
import com.dormitory.service.dto.ElectricityDTO;
@Service
public class ElectricityServiceImpl implements ElectricityService {
@Resource
private ElectricityDAO electricityDAO;
@Resource
private StudentDAO studentDAO;
@Resource
private DormitoryDAO dormitoryDAO;

	/* (non-Javadoc)
	 * @see com.dormitory.service.ElectricityService#getElectricity(java.lang.Integer)
	 */
	@Override
	public ElectricityDTO getElectricity(Integer dormitoryId) {
		Dormitory dormitory=dormitoryDAO.getDormitory(dormitoryId);
		Electricity electricity=electricityDAO.getElectricity(dormitoryId);
		ElectricityDTO electricityDTO=new ElectricityDTO();
		electricityDTO.init(dormitory, electricity);
		return electricityDTO;
	}
	/**
	 * @return the electricityDAO
	 */
	public ElectricityDAO getElectricityDAO() {
		return electricityDAO;
	}
	/**
	 * @param electricityDAO the electricityDAO to set
	 */
	public void setElectricityDAO(ElectricityDAO electricityDAO) {
		this.electricityDAO = electricityDAO;
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
