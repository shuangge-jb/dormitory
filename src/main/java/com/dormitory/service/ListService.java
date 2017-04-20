package com.dormitory.service;

import java.util.List;

public interface ListService<T> {
	/**
	 * 查找出所有对象，按时间降序
	 * 
	 * @return
	 */
public List<T> list();
}
