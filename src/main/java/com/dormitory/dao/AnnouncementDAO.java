package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.dormitory.entity.Announcement;

public interface AnnouncementDAO {
	/**
	 * 
	 * @param n
	 *            可选参数，表示选取的数量,为null时查找全部对象
	 * @return 按时间排序的对象list
	 * @author guo.junbao
	 * @date 2017-4-11
	 */
	public List<Announcement> listAnnouncement(@Param("n") Integer n);

	/**
	 * 由主键查找对象
	 * 
	 * @param announcementId
	 * @return
	 */
	public Announcement getAnnouncement(
			@Param("announcementId") Integer announcementId);
	/**
	 * 返回最近插入的主键，无插入时返回0，必须在插入后调用
	 * @return
	 */
	public Integer getLastInsertId();

	/**
	 * 插入
	 * 
	 * @param announcement
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	public void saveAnnouncement(
			 Announcement announcement);

	/**
	 * 修改
	 * 
	 * @param announcement
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	public void updateAnnouncement(
			Announcement announcement);

	/**
	 * 删除
	 * 
	 * @param announcementId
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	public void removeAnnouncement(
			@Param("announcementId") Integer announcementId);

}