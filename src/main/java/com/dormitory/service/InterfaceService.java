package com.dormitory.service;

import java.util.List;
import java.util.Map;

import com.dormitory.entity.Interface;

public interface InterfaceService
		extends GetService<Interface, Integer>, SaveOrUpdateService<Interface>, RemoveService<Interface> {
	public Map<String,Object> listByDeviceId(Long deviceId,Integer pageIndex,Integer pageSize);
}
