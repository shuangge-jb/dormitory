package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.RepairRecordDAO;
import com.dormitory.entity.RepairRecord;
import com.dormitory.service.RepairRecordService;

@Service
public class RepairRecordServiceImpl implements RepairRecordService {
	@Resource
	private RepairRecordDAO repairRecordDAO;

	@Override
	public List<RepairRecord> list(Integer pageIndex,Integer pageSize) {
		return repairRecordDAO.list(pageIndex,pageSize);
	}

	@Override
	public List<RepairRecord> listLimit(Integer n) {
		return repairRecordDAO.listLimit(n);
	}

	@Override
	public List<RepairRecord> listByDormitoryId(Integer dormitoryId,Integer pageIndex,Integer pageSize) {
		return repairRecordDAO.listByDormitoryId(dormitoryId,pageIndex,pageSize);
	}

	@Override
	public RepairRecord get(Integer repairRecordId) {
		return repairRecordDAO.get(repairRecordId);
	}

	@Transactional
	@Override
	public RepairRecord saveOrUpdate(RepairRecord repairRecord) {
		RepairRecord temp = repairRecordDAO.get(repairRecord
				.getRepairRecordId());
		if (temp == null) {
			repairRecordDAO.save(repairRecord);
		} else {
			repairRecordDAO.update(repairRecord);
		}
		return repairRecord;
	}

	@Transactional
	@Override
	public RepairRecord remove(RepairRecord repairRecord) {
		repairRecordDAO.remove(repairRecord.getRepairRecordId());
		return repairRecord;
	}

	@Override
	public Integer getLastInsertId() {
		return repairRecordDAO.gerLastInsertId();
	}

	

}
