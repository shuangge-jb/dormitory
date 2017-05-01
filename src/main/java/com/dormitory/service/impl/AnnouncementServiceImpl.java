package com.dormitory.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Override
	public List<Announcement> list(Integer pageIndex,Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		List<Announcement>list=announcementDAO.list(start,pageSize);
		return list;
	}
	@Override
	public List<Announcement> listByBuildingId(Integer buildingId,Integer pageIndex,Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		List<Announcement>list=announcementDAO.listByBuildingId(buildingId, start, pageSize);
		
		return list;
	}
	//TODO
	@Override
	public List<Announcement> listByDormitoryId(Integer dormitoryId,Integer pageIndex, Integer pageSize){
		return null;
	}
	

	@Override
	public Integer getSize() {
		return announcementDAO.getSize();
	}

	@Override
	public Integer getSizeByBuildingId(Integer buildingId) {
		return announcementDAO.getSizeByBuildingId(buildingId);
	}

}
