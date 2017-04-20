package com.dormitory.service;

import com.dormitory.entity.Announcement;

public interface AnnouncementService extends GetService<Announcement,Integer>,ListService<Announcement>, ListLimitService<Announcement>,
		SaveOrUpdateService<Announcement>, RemoveService<Announcement> {

}
