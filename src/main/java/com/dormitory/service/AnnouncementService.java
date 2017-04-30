package com.dormitory.service;

import java.util.Map;

import com.dormitory.entity.Announcement;

public interface AnnouncementService extends GetService<Announcement, Integer>, ListService<Announcement>,
		ListLimitService<Announcement>, SaveOrUpdateService<Announcement>, RemoveService<Announcement> {
	Map<String, Object> listByBuildingId(Integer authorId, Integer pageIndex, Integer pageSize);
}
