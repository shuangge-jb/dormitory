package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.dormitory.dao.DeviceDAO;
import com.dormitory.entity.Device;
import com.dormitory.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Resource
	private DeviceDAO deviceDAO;

	public DeviceServiceImpl() {

	}

	public DeviceDAO getDeviceDAO() {
		return deviceDAO;
	}

	public void setDeviceDAO(DeviceDAO deviceDAO) {
		this.deviceDAO = deviceDAO;
	}

	@Override
	public Device get(Long id) {
		return deviceDAO.get(id);
	}

	@Transactional
	@Override
	public Device saveOrUpdate(Device device) {
		Device temp = deviceDAO.get(device.getDeviceId());
		if (temp == null) {
			deviceDAO.save(device);
		} else {
			deviceDAO.update(device);
		}
		return device;
	}

	@Transactional
	@Override
	public Device remove(Device device) {
		deviceDAO.remove(device);
		return device;
	}

	@Override
	public List<Device> listByDormitoryId(Integer dormitoryId) {
		return deviceDAO.listByDormitoryId(dormitoryId);
	}

	@Override
	public Long getLastInsertId() {
		return deviceDAO.getLastInsertId();
	}

}
