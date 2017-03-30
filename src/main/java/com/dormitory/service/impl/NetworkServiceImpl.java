package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.NetworkDAO;
import com.dormitory.entity.Network;
import com.dormitory.service.NetworkService;

@Service
public class NetworkServiceImpl implements NetworkService {
	@Resource
	private NetworkDAO networkMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dormitory.service.NetworkService#getNetwork(java.lang.Long)
	 */
	@Override
	public Network getNetwork(Long studentId) {
		return networkMapper.getNetwork(studentId);
	}

	/**
	 * @return the networkMapper
	 */
	public NetworkDAO getNetworkMapper() {
		return networkMapper;
	}

	/**
	 * @param networkMapper
	 *            the networkMapper to set
	 */
	public void setNetworkMapper(NetworkDAO networkMapper) {
		this.networkMapper = networkMapper;
	}

}
