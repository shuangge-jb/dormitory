package com.dormitory.service;

import java.util.List;
import java.util.Map;

public interface ListService<T> {
	/**
	 * 查找出所有对象，按时间降序
	 * 
	 * @return
	 */
public Map<String,Object> list(Integer pageIndex,Integer pageSize);
}
