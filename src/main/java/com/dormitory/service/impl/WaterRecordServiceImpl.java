package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.WaterRecordDAO;
import com.dormitory.entity.WaterRecord;
import com.dormitory.service.WaterRecordService;

@Service
public class WaterRecordServiceImpl implements WaterRecordService {
	@Resource
	private WaterRecordDAO waterRecordDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.WaterRecordService#listWaterRecord(java.lang.Integer
	 * )
	 */
	@Override
	public List<WaterRecord> listWaterRecord(Integer dormitoryId) {
		return waterRecordDAO.listWaterRecord(dormitoryId);
	}

	/**
	 * @return the waterRecordDAO
	 */
	public WaterRecordDAO getWaterRecordDAO() {
		return waterRecordDAO;
	}

	/**
	 * @param waterRecordDAO the waterRecordDAO to set
	 */
	public void setWaterRecordDAO(WaterRecordDAO waterRecordDAO) {
		this.waterRecordDAO = waterRecordDAO;
	}

	

	

}
