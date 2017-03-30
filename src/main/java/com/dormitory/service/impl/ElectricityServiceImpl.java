package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.ElectricityDAO;
import com.dormitory.entity.Electricity;
import com.dormitory.service.ElectricityService;
@Service
public class ElectricityServiceImpl implements ElectricityService {
@Resource
private ElectricityDAO electricityDAO;
	/* (non-Javadoc)
	 * @see com.dormitory.service.ElectricityService#getElectricity(java.lang.Integer)
	 */
	@Override
	public Electricity getElectricity(Integer dormitoryId) {
		return electricityDAO.getElectricity(dormitoryId);
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
	

	
}
