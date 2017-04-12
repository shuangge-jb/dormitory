package com.dormitory.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dormitory.entity.Announcement;

public interface AnnouncementService {
	public List<Announcement> listAnnouncement();

	public List<Announcement> listAnnouncementLimit(Integer n);

	/**
	 * 插入
	 * 
	 * @param announcement
	 * @return 插入的对象
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	public Announcement saveAnnouncement(Announcement announcement);

	/**
	 * 修改
	 * 
	 * @param announcement
	 * @return 修改后的对象
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	public Announcement updateAnnouncement(Announcement announcement);

	/**
	 * 删除
	 * 
	 * @param announcementId
	 * @return 删除的对象,将其变为无效
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	public Announcement removeAnnouncement(Integer announcementId);
	
	public Integer getLastInsertId();
}
