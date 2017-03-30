package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.CampusCardDAO;
import com.dormitory.entity.CampusCard;
import com.dormitory.service.CampusCardService;

@Service
public class CampusCardServiceImpl implements CampusCardService {
	@Resource
	private CampusCardDAO campusCardDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.CampusCardService#getCampusCard(java.lang.Long)
	 */
	@Override
	public CampusCard getCampusCard(Long studentId) {
		return campusCardDAO.getCampusCard(studentId);
	}

	/**
	 * @return the campusCardDAO
	 */
	public CampusCardDAO getCampusCardDAO() {
		return campusCardDAO;
	}

	/**
	 * @param campusCardDAO the campusCardDAO to set
	 */
	public void setCampusCardDAO(CampusCardDAO campusCardDAO) {
		this.campusCardDAO = campusCardDAO;
	}

	

}
