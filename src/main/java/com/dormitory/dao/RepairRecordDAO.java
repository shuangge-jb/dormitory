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
	@Select(" select r.* from repair_record r order by r.create_time desc limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.RepairRecordMapper.repairRecord")
	public List<RepairRecord> list(@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select(" select r.* from repair_record r order by r.create_time desc limit #{n} ")
	@ResultMap("com.dormitory.mapper.RepairRecordMapper.repairRecord")
	public List<RepairRecord> listLimit(@Param("n") Integer n);

	@Select(" select count(*) from repair_record ")
	public Integer getSize();

	@Select(" select r.* from repair_record r where r.dormitory_id=#{dormitoryId} order by r.create_time desc  limit #{start},#{pageSize} ")
	@ResultMap("com.dormitory.mapper.RepairRecordMapper.repairRecord")
	public List<RepairRecord> listByDormitoryId(@Param("dormitoryId") Integer dormitoryId,
			@Param("start") Integer start, @Param("pageSize") Integer pageSize);

	@Select(" select count(*) from repair_record where dormitory_id=#{dormitoryId}")
	public Integer getSizeByDormitoryId(@Param("dormitoryId") Integer dormitoryId);

	@Select(" select r.* from repair_record r where r.repair_record_id=#{repairRecordId} ")
	@ResultMap("com.dormitory.mapper.RepairRecordMapper.repairRecord")
	public RepairRecord get(@Param("repairRecordId") Integer repairRecordId);

	@Select("select LAST_INSERT_ID()f")
	public Integer gerLastInsertId();

	@Insert(" insert into repair_record(dormitory_id,device_name,content,price,state,create_time,repair_time,contact_id)  "
			+ " values(#{dormitoryId},#{deviceName},#{content},#{price},#{state},#{createTime},#{repairTime},,#{contactId}) ")
	@Options(useGeneratedKeys = true, keyProperty = "repairRecordId")
	public void save(RepairRecord repairRecord);

	@Update(" update repair_record  set dormitory_id=#{dormitoryId}, device_name=#{deviceName}, "
			+ " content=#{content},price=#{price}, create_time=#{createTime}, "
			+ " repair_time=#{repairTime},contact_id=#{contactId} " + " where repair_record_id=#{repairRecordId} ")
	public void update(RepairRecord repairRecord);

	@Update(" update repair_record " + " set state=0 " + " where repair_record_id=#{repairRecordId} ")
	public void remove(@Param("repairRecordId") Integer repairRecordId);

}
