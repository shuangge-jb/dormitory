package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.WaterDAO;
import com.dormitory.entity.Water;
import com.dormitory.service.WaterService;
@Service
public class WaterServiceImpl implements WaterService {
@Resource
private WaterDAO waterDAO;
	/* (non-Javadoc)
	 * @see com.dormitory.service.WaterService#getWater(java.lang.Integer)
	 */
	@Override
	public Water getWater(Integer dormitoryId) {
		return waterDAO.getWater(dormitoryId);
	}
	/**
	 * @return the waterDAO
	 */
	public WaterDAO getWaterDAO() {
		return waterDAO;
	}
	/**
	 * @param waterDAO the waterDAO to set
	 */
	public void setWaterDAO(WaterDAO waterDAO) {
		this.waterDAO = waterDAO;
	}
	
	

}
