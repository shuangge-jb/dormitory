package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.LostFound;

public interface LostFoundService extends GetService<LostFound, Integer>, ListLimitService<LostFound>,
		SaveOrUpdateService<LostFound> {
	List<LostFound> list(Integer pageIndex, Integer pageSize);

	Integer getSize();

	List<LostFound> listByStudentId(Long studentId, Integer pageIndex, Integer pageSize);

	Integer getSizeByStudentId(Long studentId);
	
	List<LostFound> listByBuildingId(Integer buildingId,Integer pageIndex, Integer pageSize);
	
	Integer getSizeByBuildingId(Integer buildingId);
	
	void remove(Integer lostFoundId);
}
