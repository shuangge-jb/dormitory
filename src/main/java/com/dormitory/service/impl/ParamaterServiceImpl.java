package com.dormitory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.ParamaterDAO;
import com.dormitory.entity.Paramater;
import com.dormitory.service.ParamaterService;

@Service
public class ParamaterServiceImpl implements ParamaterService {
	@Resource
	private ParamaterDAO paramaterDAO;

	@Override
	public Paramater get(Integer paramaterId) {
		return paramaterDAO.get(paramaterId);
	}

	@Override
	public Integer getLastInsertId() {
		return paramaterDAO.getLastInsertId();
	}

	@Override
	public Paramater saveOrUpdate(Paramater paramater) {
		Paramater temp = paramaterDAO.get(paramater.getParamaterId());
		if (temp == null) {
			paramaterDAO.save(paramater);
		} else {
			paramaterDAO.update(paramater);
		}
		return paramater;
	}

	@Override
	public Paramater remove(Paramater paramater) {
		paramaterDAO.remove(paramater.getParamaterId());
		return paramater;
	}

	@Override
	public List<Paramater> listByInterfaceId(Integer interfaceId, Integer pageIndex, Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		List<Paramater> list = paramaterDAO.listByInterfaceId(interfaceId, start, pageSize);
		return list;
	}

	@Override
	public Integer getSizeByInterfaceId(Integer interfaceId) {
		return paramaterDAO.getSizeByInterfaceId(interfaceId);
	}

	@Override
	public List<Paramater> listByParamName(Integer interfaceId, String paramName) {
		return paramaterDAO.listByParamName(interfaceId, paramName);
	}

}
