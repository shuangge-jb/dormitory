package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.DormitoryDAO;
import com.dormitory.entity.Dormitory;
import com.dormitory.service.DormitoryService;
@Service
public class DormitoryServiceImpl implements DormitoryService {
@Resource
private DormitoryDAO dormitoryDAO;
	/* (non-Javadoc)
	 * @see com.dormitory.service.DormitoryService#getDormitory(java.lang.String, java.lang.String)
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
