package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.RepairRecord;

public interface RepairRecordService {
	public List<RepairRecord> list();

	public List<RepairRecord> listLimit(Integer n);

	public List<RepairRecord> listByDormitoryId(Integer dormitoryId);

	public RepairRecord get(Integer repairRecordId);

	/**
	 * 插入
	 * 
	 * @param lostFound
	 * @return
	 */
	public RepairRecord save(RepairRecord repairRecord);

	/**
	 * 修改
	 * 
	 * @param lostFound
	 * @return
	 */
	public RepairRecord update(RepairRecord repairRecord);

	/**
	 * 删除
	 * 
	 * @param lostFound
	 * @return
	 */
	public RepairRecord remove(RepairRecord repairRecord);

}
