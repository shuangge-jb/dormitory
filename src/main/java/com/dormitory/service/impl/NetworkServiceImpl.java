package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.NetworkDAO;
import com.dormitory.entity.Network;
import com.dormitory.service.NetworkService;

@Service
public class NetworkServiceImpl implements NetworkService {
	@Resource
	private NetworkDAO networkDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dormitory.service.NetworkService#getNetwork(java.lang.Long)
	 */
	@Override
	public Network getNetwork(Long studentId) {
		return networkDAO.getNetwork(studentId);
	}

	/**
	 * @return the networkDAO
	 */
	public NetworkDAO getNetworkDAO() {
		return networkDAO;
	}

	/**
	 * @param networkDAO the networkDAO to set
	 */
	public void setNetworkDAO(NetworkDAO networkDAO) {
		this.networkDAO = networkDAO;
	}

	

}
