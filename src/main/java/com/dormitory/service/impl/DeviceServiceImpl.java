package com.dormitory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.dormitory.dao.DeviceDAO;
import com.dormitory.entity.Device;
import com.dormitory.service.DeviceService;
import com.dormitory.service.HTTPService;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Resource
	private DeviceDAO deviceDAO;
	@Resource
	private HTTPService httpService;

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
	public Long getLastInsertId() {
		return deviceDAO.getLastInsertId();
	}

	@Override
	public List<Device> list(Integer pageIndex,Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		return deviceDAO.list(start, pageSize);
	}

	@Override
	public Long getSize() {
		return deviceDAO.getSize();
	}

	@Override
	public List<Device> getByName(String deviceName) {
		return deviceDAO.getByName(deviceName);
	}

	

}
