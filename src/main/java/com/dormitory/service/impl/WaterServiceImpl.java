package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.DormitoryDAO;
import com.dormitory.dao.StudentDAO;
import com.dormitory.dao.WaterDAO;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.entity.Water;
import com.dormitory.service.WaterService;
import com.dormitory.service.dto.WaterDTO;

@Service
public class WaterServiceImpl implements WaterService {
	@Resource
	private WaterDAO waterDAO;
	@Resource
	private DormitoryDAO dormitoryDAO;
	@Resource
	private StudentDAO studentDAO;

	

	/* (non-Javadoc)
	 * @see com.dormitory.service.WaterService#getWater(java.lang.Integer)
	 */
	@Override
	public WaterDTO getWater(Integer dormitoryId) {
		Dormitory dormitory = dormitoryDAO.getDormitory(dormitoryId);
		Water water = waterDAO.getWater(dormitoryId);
		WaterDTO waterDTO = new WaterDTO();
		waterDTO.init(dormitory, water);
		return waterDTO;
	}

	/**
	 * @return the waterDAO
	 */
	public WaterDAO getWaterDAO() {
		return waterDAO;
	}

	/**
	 * @param waterDAO
	 *            the waterDAO to set
	 */
	public void setWaterDAO(WaterDAO waterDAO) {
		this.waterDAO = waterDAO;
	}

	/**
	 * @return the dormitoryDAO
	 */
	public DormitoryDAO getDormitoryDAO() {
		return dormitoryDAO;
	}

	/**
	 * @param dormitoryDAO
	 *            the dormitoryDAO to set
	 */
	public void setDormitoryDAO(DormitoryDAO dormitoryDAO) {
		this.dormitoryDAO = dormitoryDAO;
	}

	/**
	 * @return the studentDAO
	 */
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	/**
	 * @param studentDAO
	 *            the studentDAO to set
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

}
