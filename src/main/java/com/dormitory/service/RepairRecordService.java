package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.RepairRecord;

public interface RepairRecordService extends GetService<RepairRecord,Integer>,ListService<RepairRecord>, ListLimitService<RepairRecord>,
		ListByDormitoryIdService<RepairRecord>, SaveOrUpdateService<RepairRecord>, RemoveService<RepairRecord> {


}
