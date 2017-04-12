package com.dormitory.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.dormitory.entity.RepairRecord;

public interface RepairRecordDAO {
	@Select(" select r.* from repair_record r order by create_time desc ")
	@ResultMap("com.dormitory.mapper.RepairRecordMapper.repairRecord")
	public List<RepairRecord> listRepairRecord();

}
