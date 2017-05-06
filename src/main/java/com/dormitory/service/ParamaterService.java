package com.dormitory.service;

import java.util.List;
import java.util.Map;

import com.dormitory.dto.ParamaterDTO;
import com.dormitory.entity.Paramater;

public interface ParamaterService
		extends GetService<Paramater, Integer>, SaveOrUpdateService<Paramater>,RemoveService<Paramater> {
	public List<ParamaterDTO> listByInterfaceId(Integer interfaceId, Integer pageIndex, Integer pageSize);

	public Integer getSizeByInterfaceId(Integer interfaceId);

	List<Paramater> listByParamName(Integer interfaceId, String paramName);
	List<ParamaterDTO> listAll(Integer pageIndex, Integer pageSize);
	
}
