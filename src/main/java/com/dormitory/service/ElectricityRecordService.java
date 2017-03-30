package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.ElectricityRecord;

public interface ElectricityRecordService {
	public List<ElectricityRecord> listElectricityRecord(Integer dormitoryId);
}
