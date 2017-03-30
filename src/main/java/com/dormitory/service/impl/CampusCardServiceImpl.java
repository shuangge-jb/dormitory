package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.CampusCardDAO;
import com.dormitory.entity.CampusCard;
import com.dormitory.service.CampusCardService;

@Service
public class CampusCardServiceImpl implements CampusCardService {
	@Resource
	private CampusCardDAO campusCardMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.CampusCardService#getCampusCard(java.lang.Long)
	 */
	@Override
	public CampusCard getCampusCard(Long studentId) {
		return campusCardMapper.getCampusCard(studentId);
	}

	/**
	 * @return the campusCardMapper
	 */
	public CampusCardDAO getCampusCardMapper() {
		return campusCardMapper;
	}

	/**
	 * @param campusCardMapper
	 *            the campusCardMapper to set
	 */
	public void setCampusCardMapper(CampusCardDAO campusCardMapper) {
		this.campusCardMapper = campusCardMapper;
	}

}
