package com.dormitory.service;

import com.dormitory.entity.Dormitory;

/**
 * 
 * @author guo.junbao
 * @date 2017-3-29
 *
 */
public interface DormitoryService {
	public Dormitory get(Long studentId);
	public Dormitory get(Integer dormitoryId);
	public Dormitory saveOrUpdate(Dormitory dormitory);
	public Dormitory remove(Dormitory dormitory);
}
