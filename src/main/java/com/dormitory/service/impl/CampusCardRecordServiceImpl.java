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
private CampusCardRecordDAO campusCardRecordMapper;
	/* (non-Javadoc)
	 * @see com.dormitory.service.CampusCardRecordService#listCampusCardRecord(java.lang.Long)
	 */
	@Override
	public List<CampusCardRecord> listCampusCardRecord(Long studentId) {
		return campusCardRecordMapper.listCampusCardRecord(studentId);
	}
	/**
	 * @return the campusCardRecordMapper
	 */
	public CampusCardRecordDAO getCampusCardRecordMapper() {
		return campusCardRecordMapper;
	}
	/**
	 * @param campusCardRecordMapper the campusCardRecordMapper to set
	 */
	public void setCampusCardRecordMapper(
			CampusCardRecordDAO campusCardRecordMapper) {
		this.campusCardRecordMapper = campusCardRecordMapper;
	}

	
}
