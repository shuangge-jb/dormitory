package com.dormitory.service;

import java.util.List;
import java.util.Map;

import com.dormitory.entity.Interface;

public interface InterfaceService
		extends GetService<Interface, Integer>, SaveOrUpdateService<Interface>, RemoveService<Interface> {
	public List<Interface> listByDeviceId(Long deviceId, Integer pageIndex, Integer pageSize);

	public Integer getSizeByDeviceId(Long deviceId);

	public List<Interface> listByInterfaceName(Long deviceId, String interfaceName);

	public List<Map<String, String>> listByDeviceIdJSON(Long deviceId);

	public List<Interface> listLike(String keyword, Long deviceId, Integer pageIndex, Integer pageSize);

	public Integer getSizeLike(String keyword, Long deviceId);

	public List<Interface> listByDeviceIdValid(Long deviceId, Integer pageIndex, Integer pageSize);

	public Integer getSizeByDeviceIdValid(Long deviceId);

}
