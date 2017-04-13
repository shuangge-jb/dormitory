package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.dormitory.entity.RepairRecord;

public interface RepairRecordDAO {
	@Select(" select r.* from repair_record r order by create_time desc ")
	@ResultMap("com.dormitory.mapper.RepairRecordMapper.repairRecord")
	public List<RepairRecord> list();
	@Select(" select r.* from repair_record r where r.dormitory_id=#{dormitoryId} order by r.create_time desc ")
	@ResultMap("com.dormitory.mapper.RepairRecordMapper.repairRecord")
	public List<RepairRecord> listByDormitoryId(@Param("dormitoryId")Integer dormitoryId);

	@Insert(" insert into repair_record(dormitory_id,content,create_time,repair_time,state)  "
			+ " values(#{dormitoryId},#{content},#{createTime},#{repairTime},#{state}) ")
	@Options(useGeneratedKeys = true, keyProperty = "repairRecordId")
	public void save(RepairRecord repairRecord);

	@Update(" update repair_record  set dormitory_id=#{dormitoryId}, "
			+ " content=#{content},  create_time=#{createTime}, "
			+ " repair_time=#{repairTime} "
			+ " where repair_record_id=#{repairRecordId} ")
	public void update(RepairRecord repairRecord);

	@Update(" update repair_record " + " set state=0 "
			+ " where repair_record_id=#{repairRecordId} ")
	public void remove(@Param("repairRecordId") Integer repairRecordId);

}
