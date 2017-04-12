package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dormitory.dao.AnnouncementDAO;
import com.dormitory.entity.Announcement;
import com.dormitory.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	@Resource
	private AnnouncementDAO announcementDAO;

	@Override
	public List<Announcement> listAnnouncement() {

		return announcementDAO.listAnnouncement(null);
	}

	@Override
	public List<Announcement> listAnnouncementLimit(Integer n) {
		return announcementDAO.listAnnouncement(n);
	}

}
