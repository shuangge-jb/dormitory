package com.dormitory.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dormitory.dao.AnnouncementDAO;
import com.dormitory.entity.Announcement;
import com.dormitory.service.AnnouncementService;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
	@Resource
	private AnnouncementDAO announcementDAO;

	@Override
	public List<Announcement> list() {

		return announcementDAO.list();
	}

	@Override
	public List<Announcement> listLimit(Integer n) {
		return announcementDAO.listLimit(n);
	}

	@Override
	public Announcement get(Integer announcementId) {
		return announcementDAO.get(announcementId);
	}

	@Override
	public Integer getLastInsertId() {
		return announcementDAO.getLastInsertId();
	}

	@Override
	@Transactional
	public Announcement saveOrUpdate(Announcement announcement) {
		Integer oldAnnouncementId = announcement.getAnnouncementId();
		Announcement temp = announcementDAO.get(oldAnnouncementId);
		if (temp == null) {
			announcementDAO.save(announcement);
		}else{
			announcementDAO.update(announcement);
		}
		return announcement;

	}

	@Override
	@Transactional
	public Announcement remove(Announcement announcement) {
		announcementDAO.remove(announcement);
		return announcement;
	}

}
