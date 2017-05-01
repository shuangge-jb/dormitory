package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.Postcard;

public interface PostcardService extends GetService<Postcard, Integer>, ListLimitService<Postcard>,
		SaveOrUpdateService<Postcard>, RemoveService<Postcard> {
	List<Postcard> list(Integer pageIndex, Integer pageSize);

	Integer getSize();

	List<Postcard> listByStudentId(Long studentId, Integer pageIndex, Integer pageSize);

	Integer getSizeByStudentId(Long studentId);
	
	List<Postcard> listByBuildingId(Integer buildingId, Integer pageIndex, Integer pageSize);
	
	Integer getSizeByBuildingId(Integer buildingId);
}
