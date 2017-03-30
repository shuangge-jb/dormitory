package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.NetworkRecordDAO;
import com.dormitory.entity.NetworkRecord;
import com.dormitory.service.NetworkRecordService;
@Service
public class NetworkRecordServiceImpl implements NetworkRecordService {
@Resource
private NetworkRecordDAO networkRecordMapper;
	/* (non-Javadoc)
	 * @see com.dormitory.service.NetworkRecordService#listNetworkRecord(java.lang.Long)
	 */
	@Override
	public List<NetworkRecord> listNetworkRecord(Long studentId) {
		return networkRecordMapper.listNetworkRecord(studentId);
	}
	/**
	 * @return the networkRecordMapper
	 */
	public NetworkRecordDAO getNetworkRecordMapper() {
		return networkRecordMapper;
	}
	/**
	 * @param networkRecordMapper the networkRecordMapper to set
	 */
	public void setNetworkRecordMapper(NetworkRecordDAO networkRecordMapper) {
		this.networkRecordMapper = networkRecordMapper;
	}

	
}
