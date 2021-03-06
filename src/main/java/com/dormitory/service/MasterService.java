package com.dormitory.service;

import java.util.List;

import com.dormitory.dto.master.MasterDTO;
import com.dormitory.entity.Master;
import com.dormitory.entity.Student;

public interface MasterService extends GetService<Master, Integer>, SaveOrUpdateService<MasterDTO> {
	List<MasterDTO> list();

	List<MasterDTO> list(Integer pageIndex, Integer pageSize);

	Integer getSize();
	
	Master updatePassword(Master master);
	
	void remove(Integer masterId);
	List<Student> listStudentByMasterId(Integer masterId);
}
