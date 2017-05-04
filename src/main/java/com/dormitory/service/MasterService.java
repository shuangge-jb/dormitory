package com.dormitory.service;

import java.util.List;

import com.dormitory.dto.master.MasterDTO;
import com.dormitory.entity.Master;

public interface MasterService extends GetService<Master, Integer>, SaveOrUpdateService<MasterDTO>, RemoveService<Master> {
	List<Master> list();

	List<Master> list(Integer pageIndex, Integer pageSize);

	Integer getSize();
	
	Master updatePassword(Master master);
}
