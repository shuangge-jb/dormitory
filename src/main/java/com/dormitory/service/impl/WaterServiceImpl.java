package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.WaterDAO;
import com.dormitory.entity.Water;
import com.dormitory.service.WaterService;
@Service
public class WaterServiceImpl implements WaterService {
@Resource
private WaterDAO waterMapper;
	/* (non-Javadoc)
	 * @see com.dormitory.service.WaterService#getWater(java.lang.Integer)
	 */
	@Override
	public Water getWater(Integer dormitoryId) {
		return waterMapper.getWater(dormitoryId);
	}
	/**
	 * @return the waterMapper
	 */
	public WaterDAO getWaterMapper() {
		return waterMapper;
	}
	/**
	 * @param waterMapper the waterMapper to set
	 */
	public void setWaterMapper(WaterDAO waterMapper) {
		this.waterMapper = waterMapper;
	}

}
