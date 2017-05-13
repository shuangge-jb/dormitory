package com.dormitory.service;

import java.util.List;

import com.dormitory.dto.PostcardDTO;
import com.dormitory.entity.Postcard;

public interface PostcardService extends GetService<PostcardDTO, Integer>, ListLimitService<PostcardDTO>,
		SaveOrUpdateService<Postcard> {
	List<PostcardDTO> list(Integer pageIndex, Integer pageSize);

	Integer getSize();

	List<PostcardDTO> listByStudentId(Long studentId, Integer pageIndex, Integer pageSize);

	Integer getSizeByStudentId(Long studentId);
	
	List<PostcardDTO> listByBuildingId(Integer buildingId, Integer pageIndex, Integer pageSize);
	
	Integer getSizeByBuildingId(Integer buildingId);
	
	void remove(Integer postcardId);
}
