package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.ElectricityDAO;
import com.dormitory.entity.Electricity;
import com.dormitory.service.ElectricityService;
@Service
public class ElectricityServiceImpl implements ElectricityService {
@Resource
private ElectricityDAO electricityMapper;
	/* (non-Javadoc)
	 * @see com.dormitory.service.ElectricityService#getElectricity(java.lang.Integer)
	 */
	@Override
	public Electricity getElectricity(Integer dormitoryId) {
		return electricityMapper.getElectricity(dormitoryId);
	}
	/**
	 * @return the electricityMapper
	 */
	public ElectricityDAO getElectricityMapper() {
		return electricityMapper;
	}
	/**
	 * @param electricityMapper the electricityMapper to set
	 */
	public void setElectricityMapper(ElectricityDAO electricityMapper) {
		this.electricityMapper = electricityMapper;
	}

	
}
