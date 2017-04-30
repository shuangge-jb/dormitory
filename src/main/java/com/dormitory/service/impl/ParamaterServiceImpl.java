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
	public Map<String, Object> listByInterfaceId(Integer interfaceId, Integer pageIndex, Integer pageSize) {
		Map<String, Object> map = new HashMap<String, Object>(3);
		List<Paramater> list = paramaterDAO.listByInterfaceId(interfaceId, pageIndex, pageSize);
		Integer total = paramaterDAO.getSize(interfaceId);
		boolean result = (list != null);
		map.put("data", list);
		map.put("total", total);
		map.put("result", result);
		return map;
	}

}
