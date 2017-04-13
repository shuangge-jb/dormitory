package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.RepairRecordDAO;
import com.dormitory.entity.RepairRecord;
import com.dormitory.service.RepairRecordService;
@Service
public class RepairRecordServiceImpl implements RepairRecordService {
@Resource
private RepairRecordDAO repairRecordDAO;
	@Override
	public List<RepairRecord> list() {
		return repairRecordDAO.list();
	}

	@Override
	public List<RepairRecord> listLimit(Integer n) {
		return repairRecordDAO.listLimit(n);
	}

	@Override
	public List<RepairRecord> listByDormitoryId(Integer dormitoryId) {
		return repairRecordDAO.listByDormitoryId(dormitoryId);
	}

	@Override
	public RepairRecord get(Integer repairRecordId) {
		return repairRecordDAO.get(repairRecordId);
	}

	@Override
	public RepairRecord save(RepairRecord repairRecord) {
		RepairRecord temp=repairRecordDAO.get(repairRecord.getRepairRecordId());
		if(temp==null){
			repairRecordDAO.save(repairRecord);
		}else{
			repairRecordDAO.update(repairRecord);
		}
		return repairRecord;
	}

	@Override
	public RepairRecord update(RepairRecord repairRecord) {
		repairRecordDAO.update(repairRecord);
		return repairRecord;
	}

	@Override
	public RepairRecord remove(RepairRecord repairRecord) {
		repairRecordDAO.remove(repairRecord.getRepairRecordId());
		return repairRecord;
	}

}
