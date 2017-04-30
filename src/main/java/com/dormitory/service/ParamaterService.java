package com.dormitory.service;

import java.util.Map;

import com.dormitory.entity.Paramater;

public interface ParamaterService
		extends GetService<Paramater, Integer>, SaveOrUpdateService<Paramater>, RemoveService<Paramater> {
	public Map<String, Object> listByInterfaceId(Integer interfaceId, Integer pageIndex, Integer pageSize);
}
