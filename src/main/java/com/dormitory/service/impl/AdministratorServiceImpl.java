package com.dormitory.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.AdministratorDAO;
import com.dormitory.entity.Administrator;
import com.dormitory.service.AdministratorService;
@Service
public class AdministratorServiceImpl implements AdministratorService {
	@Resource
	private AdministratorDAO administratorDAO;

	public AdministratorServiceImpl() {

	}

	@Override
	public Administrator get(Integer id) {
		return administratorDAO.get(id);
	}

	@Override
	public Integer getLastInsertId() {
		return administratorDAO.getLastInsertId();
	}

	@Transactional
	@Override
	public Administrator saveOrUpdate(Administrator administrator) {
		Administrator temp = administratorDAO.get(administrator.getAdministratorId());
		if (temp == null) {
			administratorDAO.save(administrator);
		} else {
			administratorDAO.update(administrator);
		}
		return administrator;
	}

	@Transactional
	@Override
	public Administrator remove(Administrator administrator) {
		administratorDAO.remove(administrator);
		return administrator;
	}

}
