package com.dormitory.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.MasterDAO;
import com.dormitory.entity.Master;
import com.dormitory.service.MasterService;
@Service
public class MasterServiceImpl implements MasterService {
	@Resource
	private MasterDAO administratorDAO;

	public MasterServiceImpl() {

	}

	@Override
	public Master get(Integer id) {
		return administratorDAO.get(id);
	}

	@Override
	public Integer getLastInsertId() {
		return administratorDAO.getLastInsertId();
	}

	@Transactional
	@Override
	public Master saveOrUpdate(Master administrator) {
		Master temp = administratorDAO.get(administrator.getAdministratorId());
		if (temp == null) {
			administratorDAO.save(administrator);
		} else {
			administratorDAO.update(administrator);
		}
		return administrator;
	}

	@Transactional
	@Override
	public Master remove(Master administrator) {
		administratorDAO.remove(administrator);
		return administrator;
	}

}
