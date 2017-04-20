package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	@Select(" select * from announcement limit #{n}")
	@ResultMap("com.dormitory.mapper.AnnouncementMapper.announcement")
	public List<Announcement> list(@Param("n") Integer n);

	/**
	 * 由主键查找对象
	 * 
	 * @param announcementId
	 * @return
	 */
	@Select("select * from announcement where announcement_id=#{announcementId}")
	@ResultMap("com.dormitory.mapper.AnnouncementMapper.announcement")
	public Announcement get(
			@Param("announcementId") Integer announcementId);
	/**
	 * 返回最近插入的主键，无插入时返回0，必须在插入后调用
	 * @return
	 */
	@Select("select LAST_INSERT_ID() ")
	public Integer getLastInsertId();

	/**
	 * 插入
	 * 
	 * @param announcement
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	@Insert(" insert into announcement(announcement_id,content,create_time,state) "
			+" values(#{announcementId},#{content},#{createTime},#{state}) ")
	@Options(useGeneratedKeys = true, keyProperty = "announcementId")
	public void save(
			 Announcement announcement);

	/**
	 * 修改
	 * 
	 * @param announcement
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	@Update(" update announcement set content=#{content} where announcement_id=#{announcementId} ")
	public void update(
			Announcement announcement);

	/**
	 * 删除
	 * 
	 * @param announcementId
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	@Update(" update announcement set state=0 where announcement_id=#{announcementId} ")
	public void remove(
			@Param("announcementId") Integer announcementId);

}