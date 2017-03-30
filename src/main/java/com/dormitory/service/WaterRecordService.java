package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.WaterRecord;

public interface WaterRecordService {
	public List<WaterRecord> listWaterRecord(Integer dormitoryId);
}
