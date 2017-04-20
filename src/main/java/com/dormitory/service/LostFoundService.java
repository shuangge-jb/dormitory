package com.dormitory.service;

import com.dormitory.entity.LostFound;

public interface LostFoundService extends GetService<LostFound,Integer>,ListService<LostFound>, ListLimitService<LostFound>,
		ListByStudentIdService<LostFound>, SaveOrUpdateService<LostFound>, RemoveService<LostFound> {

}
