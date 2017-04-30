package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.MasterDAO;
import com.dormitory.entity.Master;
import com.dormitory.service.MasterService;
@Service
public class MasterServiceImpl implements MasterService {
	@Resource
	private MasterDAO masterDAO;

	public MasterServiceImpl() {

	}

	@Override
	public Master get(Integer id) {
		return masterDAO.get(id);
	}

	@Override
	public Integer getLastInsertId() {
		return masterDAO.getLastInsertId();
	}

	@Transactional
	@Override
	public Master saveOrUpdate(Master master) {
		Master temp = masterDAO.get(master.getMasterId());
		if (temp == null) {
			masterDAO.save(master);
		} else {
			masterDAO.update(master);
		}
		return master;
	}

	@Transactional
	@Override
	public Master remove(Master master) {
		masterDAO.remove(master);
		return master;
	}

	@Override
	public List<Master> list() {
		
		return masterDAO.list();
	}

	@Override
	public List<Master> list(Integer pageIndex, Integer pageSize) {
		return masterDAO.list(pageIndex, pageSize);
	}

	@Override
	public Integer getSize() {
		return masterDAO.getSize();
	}

}
