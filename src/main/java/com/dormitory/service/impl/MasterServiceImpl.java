package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.BuildingDAO;
import com.dormitory.dao.MasterDAO;
import com.dormitory.dto.master.MasterDTO;
import com.dormitory.entity.Building;
import com.dormitory.entity.Master;
import com.dormitory.service.BuildingService;
import com.dormitory.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {
	@Resource
	private MasterDAO masterDAO;
	@Resource
	private BuildingDAO buildingDAO;

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
	public MasterDTO saveOrUpdate(MasterDTO masterDTO) {
		Building building = buildingDAO.getByBuildingName(masterDTO.getBuildingName().toUpperCase());
		Master master = masterDTO.getMaster();
		master.setBuildingId(building.getBuildingId());
		Master temp = masterDAO.get(master.getMasterId());
		if (temp == null) {
			masterDAO.save(master);
		} else {
			masterDAO.update(master);
		}
		System.out.println("masterId:"+master.getMasterId());
		MasterDTO result= new MasterDTO();
		result.setMaster(master);
		return result;
	}

	@Transactional
	@Override
	public void remove(Integer masterId) {
		masterDAO.remove(masterId);
	}

	@Override
	public List<Master> list() {
		Integer total = masterDAO.getSize();
		return list(0, total);
	}

	@Override
	public List<Master> list(Integer pageIndex, Integer pageSize) {
		Integer start = (pageIndex - 1) * pageSize;
		return masterDAO.list(start, pageSize);
	}

	@Override
	public Integer getSize() {
		return masterDAO.getSize();
	}

	@Override
	public Master updatePassword(Master master) {
		masterDAO.updatePassword(master);
		return master;
	}

}
