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
	private WaterRecordDAO waterRecordMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.WaterRecordService#listWaterRecord(java.lang.Integer
	 * )
	 */
	@Override
	public List<WaterRecord> listWaterRecord(Integer dormitoryId) {
		return waterRecordMapper.listWaterRecord(dormitoryId);
	}

	/**
	 * @return the waterRecordMapper
	 */
	public WaterRecordDAO getWaterRecordMapper() {
		return waterRecordMapper;
	}

	/**
	 * @param waterRecordMapper
	 *            the waterRecordMapper to set
	 */
	public void setWaterRecordMapper(WaterRecordDAO waterRecordMapper) {
		this.waterRecordMapper = waterRecordMapper;
	}

}
