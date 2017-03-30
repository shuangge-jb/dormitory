package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.NetworkRecord;

public interface NetworkRecordService {
	public List<NetworkRecord> listNetworkRecord(Long studentId);
}
