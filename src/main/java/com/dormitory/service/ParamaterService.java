package com.dormitory.service;

import java.util.List;
import java.util.Map;

import com.dormitory.entity.Paramater;

public interface ParamaterService
		extends GetService<Paramater, Integer>, SaveOrUpdateService<Paramater>, RemoveService<Paramater> {
	public List<Paramater> listByInterfaceId(Integer interfaceId, Integer pageIndex, Integer pageSize);
	public Integer getSizeByInterfaceId(Integer interfaceId);
}
