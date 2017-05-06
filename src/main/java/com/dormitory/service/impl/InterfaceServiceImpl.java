package com.dormitory.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.InterfaceDAO;
import com.dormitory.dao.ParamaterDAO;
import com.dormitory.entity.Interface;
import com.dormitory.service.InterfaceService;
@Service
public class InterfaceServiceImpl implements InterfaceService {
@Resource
private InterfaceDAO interfaceDAO;
@Resource
private ParamaterDAO paramaterDAO;
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
	public Interface remove(Interface function) {
		interfaceDAO.remove(function.getInterfaceId());
		paramaterDAO.removeByInterfaceId(function.getInterfaceId());//级联删除功能的所有参数
		return function;
	}
	@Override
	public List<Interface> listByDeviceId(Long deviceId,Integer pageIndex,Integer pageSize){
		Integer start=(pageIndex-1)*pageSize;
		List<Interface>list=interfaceDAO.listByDeviceId(deviceId,start,pageSize);
		return list;
	}
	
	@Override
	public  Integer getSizeByDeviceId(Long deviceId){
		return interfaceDAO.getSizeByDeviceId(deviceId);
	}

	@Override
	public List<Interface> listByInterfaceName(Long deviceId,String interfaceName) {
		return interfaceDAO.listByInterfaceName(deviceId,interfaceName);
	}

	@Override
	public List<Map<String, String>> listByDeviceIdJSON(Long deviceId) {
		return interfaceDAO.listByDeviceIdJSON(deviceId);
	}
}
