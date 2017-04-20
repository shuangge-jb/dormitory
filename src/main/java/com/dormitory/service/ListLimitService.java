package com.dormitory.service;

import java.util.List;

public interface ListLimitService<T> {
	/**
	 * 按时间降序,查找出限定个数的对象，
	 * 
	 * @param n
	 * @return
	 */
	public List<T> listLimit(Integer n);
}
