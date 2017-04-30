package com.dormitory.service;

import java.util.List;
import java.util.Map;

public interface ListByStudentIdService<T> {
	/**
	 * 找出该学生的所有遗失物品
	 * 
	 * @param studentId
	 * @return
	 */
	public Map<String,Object> listByStudentId(Long studentId,Integer pageIndex,Integer pageSize);
}
