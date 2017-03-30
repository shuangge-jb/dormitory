package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.CampusCardRecord;

public interface CampusCardRecordService {
	public List<CampusCardRecord> listCampusCardRecord(Long studentId);
}
