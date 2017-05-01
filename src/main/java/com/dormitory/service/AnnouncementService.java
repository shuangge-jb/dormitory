package com.dormitory.service;

import java.util.List;
import java.util.Map;

import com.dormitory.entity.Announcement;

public interface AnnouncementService extends GetService<Announcement, Integer>, 
		ListLimitService<Announcement>, SaveOrUpdateService<Announcement>, RemoveService<Announcement> {
	List<Announcement> list(Integer pageIndex, Integer pageSize);
	List<Announcement> listByBuildingId(Integer buildingId,Integer pageIndex, Integer pageSize);
	List<Announcement> listByDormitoryId(Integer dormitoryId,Integer pageIndex, Integer pageSize);
	Integer getSize();
	Integer getSizeByBuildingId(Integer buildingId);
}
