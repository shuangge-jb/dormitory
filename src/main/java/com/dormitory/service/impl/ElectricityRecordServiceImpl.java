package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.ElectricityRecordDAO;
import com.dormitory.entity.ElectricityRecord;
import com.dormitory.service.ElectricityRecordService;

@Service
public class ElectricityRecordServiceImpl implements ElectricityRecordService {
	@Resource
	private ElectricityRecordDAO electricityRecordMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.ElectricityRecordService#listElectricityRecord(
	 * java.lang.Integer)
	 */
	@Override
	public List<ElectricityRecord> listElectricityRecord(Integer dormitoryId) {
		return electricityRecordMapper.listElectricityRecord(dormitoryId);
	}

	/**
	 * @return the electricityRecordMapper
	 */
	public ElectricityRecordDAO getElectricityRecordMapper() {
		return electricityRecordMapper;
	}

	/**
	 * @param electricityRecordMapper the electricityRecordMapper to set
	 */
	public void setElectricityRecordMapper(
			ElectricityRecordDAO electricityRecordMapper) {
		this.electricityRecordMapper = electricityRecordMapper;
	}

}
