package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.CampusCardRecordDAO;
import com.dormitory.entity.CampusCardRecord;
import com.dormitory.service.CampusCardRecordService;
@Service
public class CampusCardRecordServiceImpl implements CampusCardRecordService {
@Resource
private CampusCardRecordDAO campusCardRecordDAO;
	/* (non-Javadoc)
	 * @see com.dormitory.service.CampusCardRecordService#listCampusCardRecord(java.lang.Long)
	 */
	@Override
	public List<CampusCardRecord> listCampusCardRecord(Long studentId) {
		return campusCardRecordDAO.listCampusCardRecord(studentId);
	}
	/**
	 * @return the campusCardRecordDAO
	 */
	public CampusCardRecordDAO getCampusCardRecordDAO() {
		return campusCardRecordDAO;
	}
	/**
	 * @param campusCardRecordDAO the campusCardRecordDAO to set
	 */
	public void setCampusCardRecordDAO(CampusCardRecordDAO campusCardRecordDAO) {
		this.campusCardRecordDAO = campusCardRecordDAO;
	}
	

	
}
