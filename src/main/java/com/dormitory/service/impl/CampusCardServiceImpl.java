package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.CampusCardDAO;
import com.dormitory.dao.StudentDAO;
import com.dormitory.entity.CampusCard;
import com.dormitory.entity.Student;
import com.dormitory.service.CampusCardService;
import com.dormitory.service.dto.CampusCardDTO;

@Service
public class CampusCardServiceImpl implements CampusCardService {
	@Resource
	private CampusCardDAO campusCardDAO;
	@Resource
	private StudentDAO studentDAO;
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.CampusCardService#getCampusCard(java.lang.Long)
	 */
	@Override
	public CampusCardDTO getCampusCard(Long studentId) {
		Student student=studentDAO.getStudent(studentId);
		CampusCard campusCard= campusCardDAO.getCampusCard(studentId);
		CampusCardDTO campusCardDTO=new CampusCardDTO();
		campusCardDTO.init(student, campusCard);
		return campusCardDTO;
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
