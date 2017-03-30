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
	private ElectricityRecordDAO electricityRecordDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.ElectricityRecordService#listElectricityRecord(
	 * java.lang.Integer)
	 */
	@Override
	public List<ElectricityRecord> listElectricityRecord(Integer dormitoryId) {
		return electricityRecordDAO.listElectricityRecord(dormitoryId);
	}

	/**
	 * @return the electricityRecordDAO
	 */
	public ElectricityRecordDAO getElectricityRecordDAO() {
		return electricityRecordDAO;
	}

	/**
	 * @param electricityRecordDAO the electricityRecordDAO to set
	 */
	public void setElectricityRecordDAO(ElectricityRecordDAO electricityRecordDAO) {
		this.electricityRecordDAO = electricityRecordDAO;
	}

	

}
