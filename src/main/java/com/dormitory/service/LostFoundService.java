package com.dormitory.service;

import java.util.List;

import com.dormitory.entity.LostFound;

public interface LostFoundService extends GetService<LostFound, Integer>, ListLimitService<LostFound>,
		SaveOrUpdateService<LostFound>, RemoveService<LostFound> {
	List<LostFound> list(Integer pageIndex, Integer pageSize);

	Integer getSize();

	List<LostFound> listByStudentId(Long studentId, Integer pageIndex, Integer pageSize);

	Integer getSizeByStudentId(Long studentId);
}
