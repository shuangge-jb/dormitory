package com.dormitory.service;

import com.dormitory.service.dto.ElectricityDTO;

public interface ElectricityService {
	public ElectricityDTO getElectricity(Integer dormitoryId);
}
