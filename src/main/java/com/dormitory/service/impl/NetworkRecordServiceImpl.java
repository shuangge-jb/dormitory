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
private NetworkRecordDAO networkRecordDAO;
	/* (non-Javadoc)
	 * @see com.dormitory.service.NetworkRecordService#listNetworkRecord(java.lang.Long)
	 */
	@Override
	public List<NetworkRecord> listNetworkRecord(Long studentId) {
		return networkRecordDAO.listNetworkRecord(studentId);
	}
	/**
	 * @return the networkRecordDAO
	 */
	public NetworkRecordDAO getNetworkRecordDAO() {
		return networkRecordDAO;
	}
	/**
	 * @param networkRecordDAO the networkRecordDAO to set
	 */
	public void setNetworkRecordDAO(NetworkRecordDAO networkRecordDAO) {
		this.networkRecordDAO = networkRecordDAO;
	}
	

	
}
