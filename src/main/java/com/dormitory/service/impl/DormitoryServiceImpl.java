package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.DormitoryDAO;
import com.dormitory.entity.Dormitory;
import com.dormitory.service.DormitoryService;
@Service
public class DormitoryServiceImpl implements DormitoryService {
@Resource
private DormitoryDAO dormitoryMapper;
	/* (non-Javadoc)
	 * @see com.dormitory.service.DormitoryService#getDormitory(java.lang.String, java.lang.String)
	 */
	@Override
	public Dormitory getDormitory(String building, String room) {
		return dormitoryMapper.getDormitory(building, room);
	}
	/**
	 * @return the dormitoryMapper
	 */
	public DormitoryDAO getDormitoryMapper() {
		return dormitoryMapper;
	}
	/**
	 * @param dormitoryMapper the dormitoryMapper to set
	 */
	public void setDormitoryMapper(DormitoryDAO dormitoryMapper) {
		this.dormitoryMapper = dormitoryMapper;
	}

	
}
