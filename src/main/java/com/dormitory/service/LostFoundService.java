package com.dormitory.service;

import java.util.List;

import com.dormitory.dto.master.LostFoundDTO;
import com.dormitory.entity.LostFound;

public interface LostFoundService extends GetService<LostFound, Integer>, ListLimitService<LostFound>,
		SaveOrUpdateService<LostFound> {
	List<LostFoundDTO> list(Integer pageIndex, Integer pageSize);

	Integer getSize();

	List<LostFoundDTO> listByStudentId(Long studentId, Integer pageIndex, Integer pageSize);

	Integer getSizeByStudentId(Long studentId);
	
	List<LostFoundDTO> listByBuildingId(Integer buildingId,Integer pageIndex, Integer pageSize);
	
	Integer getSizeByBuildingId(Integer buildingId);
	
	void remove(Integer lostFoundId);
	
	void changeState(Integer lostFoundId);
}
