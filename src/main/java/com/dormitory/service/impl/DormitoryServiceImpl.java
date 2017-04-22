package com.dormitory.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.DormitoryDAO;
import com.dormitory.dao.StudentDAO;
import com.dormitory.entity.Dormitory;
import com.dormitory.entity.Student;
import com.dormitory.service.DormitoryService;
@Service
public class DormitoryServiceImpl implements DormitoryService {
@Resource
private DormitoryDAO dormitoryDAO;
@Resource
private StudentDAO userDAO;
	/* (non-Javadoc)
	 * @see com.dormitory.service.DormitoryService#getDormitory(java.lang.String, java.lang.String)
	 */
	@Override
	public Dormitory get(Long userId) {
		Student user=userDAO.get(userId);
		return get(user.getDormitoryId());
	}
	
	/* (non-Javadoc)
	 * @see com.dormitory.service.DormitoryService#getDormitory(java.lang.Integer)
	 */
	@Override
	public Dormitory get(Integer dormitoryId) {
		return dormitoryDAO.get(dormitoryId);
	}

	/**
	 * @return the dormitoryDAO
	 */
	public DormitoryDAO getDormitoryDAO() {
		return dormitoryDAO;
	}
	/**
	 * @param dormitoryDAO the dormitoryDAO to set
	 */
	public void setDormitoryDAO(DormitoryDAO dormitoryDAO) {
		this.dormitoryDAO = dormitoryDAO;
	}

	@Override
	public Dormitory saveOrUpdate(Dormitory dormitory) {
		Dormitory temp=dormitoryDAO.get(dormitory.getDormitoryId());
		if(temp==null){
			dormitoryDAO.save(dormitory);
		}else{
			dormitoryDAO.update(dormitory);
		}
		
		return dormitory;
	}

	@Override
	public Dormitory remove(Dormitory dormitory) {
		dormitoryDAO.remove(dormitory);
		return dormitory;
	}
	

	
}
