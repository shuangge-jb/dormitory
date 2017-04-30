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
	public Map<String,Object> listByDormitoryId(Integer dormitoryId, Integer pageIndex, Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>(3);
		List<Device>list=deviceDAO.listByDormitoryId(dormitoryId,pageIndex,pageSize);
		Integer total=deviceDAO.getSizeByDormitory(dormitoryId);
		boolean result=(list!=null);
		map.put("data", list);
		map.put("total", total);
		map.put("result", result);
		return map;
	}

	@Override
	public Long getLastInsertId() {
		return deviceDAO.getLastInsertId();
	}

	

}
