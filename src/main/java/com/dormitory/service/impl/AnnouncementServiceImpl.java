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
	public List<Announcement> listAnnouncement() {

		return announcementDAO.listAnnouncement(null);
	}

	@Override
	public List<Announcement> listAnnouncementLimit(Integer n) {
		return announcementDAO.listAnnouncement(n);
	}

	/* (non-Javadoc)
	 * @see com.dormitory.service.AnnouncementService#getAnnouncement(java.lang.Integer)
	 */
	@Override
	public Announcement getAnnouncement(Integer announcementId) {
		return announcementDAO.getAnnouncement(announcementId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dormitory.service.AnnouncementService#getLastInsertId()
	 */
	@Override
	public Integer getLastInsertId() {
		return announcementDAO.getLastInsertId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.AnnouncementService#saveAnnouncement(com.dormitory
	 * .entity.Announcement)
	 */
	@Override
	@Transactional
	public Announcement saveAnnouncement(Announcement announcement) {
		Integer oldAnnouncementId = announcement.getAnnouncementId();
		Announcement temp = announcementDAO.getAnnouncement(oldAnnouncementId);
		if (temp == null) {
			announcementDAO.saveAnnouncement(announcement);
		}
		return announcement;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.AnnouncementService#updateAnnouncement(com.dormitory
	 * .entity.Announcement)
	 */
	@Override
	@Transactional
	public Announcement updateAnnouncement(Announcement announcement) {
		announcementDAO.updateAnnouncement(announcement);
		return announcement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.dormitory.service.AnnouncementService#removeAnnouncement(java.lang
	 * .Integer)
	 */
	@Override
	@Transactional
	public Announcement removeAnnouncement(Integer announcementId) {
		Announcement announcement=announcementDAO.getAnnouncement(announcementId);
		announcementDAO.removeAnnouncement(announcementId);
		return announcement;
	}

}
