package com.dormitory.service.impl;

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

}
