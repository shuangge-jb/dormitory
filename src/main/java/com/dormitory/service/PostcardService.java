package com.dormitory.service;

import java.util.List;

import com.dormitory.dto.PostcardDTO;
import com.dormitory.entity.Postcard;

public interface PostcardService extends GetService<Postcard, Integer>, ListLimitService<PostcardDTO>,
		SaveOrUpdateService<Postcard> {
	List<PostcardDTO> list(Integer pageIndex, Integer pageSize);

	Integer getSize();

	List<PostcardDTO> listByBuildingId(Integer buildingId, Integer pageIndex, Integer pageSize);
	
	Integer getSizeByBuildingId(Integer buildingId);
	
	void changeState(Integer postcardId);
	
	void remove(Integer postcardId);
}
