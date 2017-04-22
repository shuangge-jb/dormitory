package com.dormitory.service;

import com.dormitory.entity.Dormitory;

/**
 * 
 * @author guo.junbao
 * @date 2017-3-29
 *
 */
public interface DormitoryService extends SaveOrUpdateService<Dormitory>,RemoveService<Dormitory>{
	public Dormitory get(Long studentId);
	public Dormitory get(Integer dormitoryId);
}
