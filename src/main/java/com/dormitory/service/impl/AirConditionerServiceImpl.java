package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.AirConditionerDAO;
import com.dormitory.entity.AirConditioner;
import com.dormitory.service.AirConditionerService;
@Service
public class AirConditionerServiceImpl implements AirConditionerService {
@Resource
private AirConditionerDAO airConditionerDAO;
	@Override
	public AirConditioner get(Integer dormitoryId) {
		return airConditionerDAO.get(dormitoryId);
	}

}
