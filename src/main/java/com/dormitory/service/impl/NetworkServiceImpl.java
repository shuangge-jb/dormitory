package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.NetworkDAO;
import com.dormitory.dao.StudentDAO;
import com.dormitory.entity.Network;
import com.dormitory.entity.Student;
import com.dormitory.service.NetworkService;
import com.dormitory.service.dto.NetworkDTO;

@Service
public class NetworkServiceImpl implements NetworkService {
	@Resource
	private NetworkDAO networkDAO;
	@Resource
	private StudentDAO studentDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dormitory.service.NetworkService#getNetwork(java.lang.Long)
	 */
	@Override
	public NetworkDTO getNetwork(Long studentId) {
		Student student=studentDAO.getStudent(studentId);
		Network network= networkDAO.getNetwork(studentId);
		NetworkDTO networkDTO=new NetworkDTO();
		networkDTO.init(student, network);
		return networkDTO;
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

	/**
	 * @return the studentDAO
	 */
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	/**
	 * @param studentDAO the studentDAO to set
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	

}
