package com.dormitory.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.BuildingDAO;
import com.dormitory.dao.DormitoryDAO;
import com.dormitory.dao.StudentDAO;
import com.dormitory.dto.DormitoryDTO;
import com.dormitory.entity.Building;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.service.DormitoryService;

@Service
public class DormitoryServiceImpl implements DormitoryService {
	@Resource
	private DormitoryDAO dormitoryDAO;
	@Resource
	private BuildingDAO buildingDAO;
	@Resource
	private StudentDAO studentDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.DormitoryService#getDormitory(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public DormitoryDTO get(Long userId) {
		Student user = studentDAO.get(userId);
		return get(user.getDormitoryId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.DormitoryService#getDormitory(java.lang.Integer)
	 */
	@Override
	public DormitoryDTO get(Integer dormitoryId) {
		Dormitory dormitory = dormitoryDAO.get(dormitoryId);
		DormitoryDTO dormitoryDTO = new DormitoryDTO(dormitory);
		String buildingName = buildingDAO.get(dormitory.getBuildingId()).getBuildngName();
		dormitoryDTO.setBuildingName(buildingName);
		return dormitoryDTO;
	}

	/**
	 * @return the dormitoryDAO
	 */
	public DormitoryDAO getDormitoryDAO() {
		return dormitoryDAO;
	}

	/**
	 * @param dormitoryDAO
	 *            the dormitoryDAO to set
	 */
	public void setDormitoryDAO(DormitoryDAO dormitoryDAO) {
		this.dormitoryDAO = dormitoryDAO;
	}

	@Transactional
	@Override
	public Dormitory saveOrUpdate(Dormitory dormitory) {
		Dormitory temp = dormitoryDAO.get(dormitory.getDormitoryId());
		if (temp == null) {
			dormitoryDAO.save(dormitory);
		} else {
			dormitoryDAO.update(dormitory);
		}

		return dormitory;
	}

	@Transactional
	@Override
	public Dormitory remove(Dormitory dormitory) {
		dormitoryDAO.remove(dormitory);
		return dormitory;
	}

	// @Override
	// public Dormitory getByBuildingNameAndRoom(String buildingName, String
	// room) {
	// Building building = buildingDAO.getByBuildingName(buildingName);
	// return dormitoryDAO.getByBuildingIdAndRoom(building.getBuildingId(),
	// room);
	// }
	@Transactional
	@Override
	public Dormitory save(String buildingName, String room) {
		Building building = buildingDAO.getByBuildingName(buildingName.toUpperCase());
		Dormitory dormitory = dormitoryDAO.getByBuildingIdAndRoom(building.getBuildingId(), room);
		if (dormitory == null) {
			dormitory = new Dormitory();
			dormitory.setBuildingId(building.getBuildingId());
			dormitory.setRoom(room);
			dormitoryDAO.save(dormitory);
		}
		return dormitory;
	}

	@Override
	public Building getBuildingByDormitoryId(Integer dormitoryId) {
		Dormitory dormitory = dormitoryDAO.get(dormitoryId);
		return buildingDAO.get(dormitory.getBuildingId());
	}

}
