package com.dormitory.service;

import java.util.List;

public interface ListByStudentIdService<T> {
	/**
	 * 找出该学生的所有遗失物品
	 * 
	 * @param studentId
	 * @return
	 */
	public List<T> listByStudentId(Long studentId,Integer pageIndex,Integer pageSize);
}
