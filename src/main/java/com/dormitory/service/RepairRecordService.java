package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.RepairRecord;

public interface RepairRecordService extends GetService<RepairRecord, Integer>, ListLimitService<RepairRecord>,
		SaveOrUpdateService<RepairRecord>, RemoveService<RepairRecord> {
	List<RepairRecord> list(Integer pageIndex, Integer pageSize);

	Integer getSize();

	List<RepairRecord> listByDormitoryId(Integer dormitoryId, Integer pageIndex, Integer pageSize);

	Integer getSizeByDormitoryId(Integer dormitoryId);
	
	List<RepairRecord> listByBuildingId(Integer buildingId, Integer pageIndex, Integer pageSize);

	Integer getSizeByBuildingId(Integer buildingId);
}
