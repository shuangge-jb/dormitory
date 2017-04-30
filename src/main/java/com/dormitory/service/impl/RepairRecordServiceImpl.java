package com.dormitory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String,Object> list(Integer pageIndex,Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>(3);
		List<RepairRecord> list=repairRecordDAO.list(pageIndex,pageSize);
		map.put("list", list);
		Integer total=repairRecordDAO.getSize();
		map.put("total", total);
		boolean result=(list!=null);
		map.put("result", result);
		return map;
	}

	@Override
	public List<RepairRecord> listLimit(Integer n) {
		return repairRecordDAO.listLimit(n);
	}

	@Override
	public Map<String,Object> listByDormitoryId(Integer dormitoryId,Integer pageIndex,Integer pageSize) {
		Map<String,Object> map=new HashMap<String,Object>(3);
		List<RepairRecord> list=repairRecordDAO.listByDormitoryId(dormitoryId,pageIndex,pageSize);
		map.put("list", list);
		Integer total=repairRecordDAO.getSizeByDormitoryId(dormitoryId);
		map.put("total", total);
		boolean result=(list!=null);
		map.put("result", result);
		return map;
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
