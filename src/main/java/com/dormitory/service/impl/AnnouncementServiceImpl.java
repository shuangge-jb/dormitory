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
	public Map<String,Object> list(Integer pageIndex,Integer pageSize) {
		List<Announcement>list=announcementDAO.list(pageIndex,pageSize);
		Integer total=announcementDAO.getSize();
		boolean result=(list!=null);
		Map<String,Object> map=new HashMap<String,Object>(3);
		map.put("data", list);
		map.put("total", total);
		map.put("result", result);
		return map;
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

	@Override
	public Map<String,Object> listByBuildingId(Integer buildingId,Integer pageIndex,Integer pageSize) {
		List<Announcement>list=announcementDAO.listByBuildingId(buildingId, pageIndex, pageSize);
		Integer total=announcementDAO.getSize();
		boolean result=(list!=null);
		Map<String,Object> map=new HashMap<String,Object>(3);
		map.put("data", list);
		map.put("total", total);
		map.put("result", result);
		return map;
	}
	
}
