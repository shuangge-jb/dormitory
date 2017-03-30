package com.dormitory.service;

import com.dormitory.service.dto.NetworkDTO;

public interface NetworkService {
	public NetworkDTO getNetwork(Long studentId);
}
