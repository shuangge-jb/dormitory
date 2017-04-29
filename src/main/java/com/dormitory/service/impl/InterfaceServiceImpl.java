package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.InterfaceDAO;
import com.dormitory.entity.Interface;
import com.dormitory.service.InterfaceService;
@Service
public class InterfaceServiceImpl implements InterfaceService {
@Resource
private InterfaceDAO interfaceDAO;

	@Override
	public Interface get(Integer interfaceId) {
		return interfaceDAO.get(interfaceId);
	}

	@Override
	public Integer getLastInsertId() {
		return interfaceDAO.getLastInsertId();
	}

	@Override
	public Interface saveOrUpdate(Interface item) {
		Interface temp=interfaceDAO.get(item.getInterfaceId());
		if(temp==null){
			interfaceDAO.save(item);
		}else{
			interfaceDAO.update(item);
		}
		return item;
	}

	@Override
	public Interface remove(Interface item) {
		interfaceDAO.remove(item);
		return item;
	}

}
