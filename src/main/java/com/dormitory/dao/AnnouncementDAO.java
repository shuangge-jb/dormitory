package com.dormitory.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
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
	@Select(" select * from announcement  order by create_time desc limit #{n}")
	@ResultMap("com.dormitory.mapper.AnnouncementMapper.announcement")
	public List<Announcement> listLimit(@Param("n") Integer n);

	@Select(" select * from announcement order by create_time desc limit (pageIndex-1)*pageSize,pageSize ")
	@ResultMap("com.dormitory.mapper.AnnouncementMapper.announcement")
	public List<Announcement> list(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

	@Select(" select * from announcement where building_id=#{buildingId} order by create_time desc limit (pageIndex-1)*pageSize,pageSize ")
	@ResultMap("com.dormitory.mapper.AnnouncementMapper.announcement")
	public List<Announcement> listByBuildingId(@Param("buildingId")Integer buildingId,@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
	@Select("select count(*) from announcement ")
	public Integer getSize();
	
	@Select(" select count(*) from announcement where building_id=#{buildingId}")
	public Integer getSizeByBuildingId(@Param("buildingId")Integer buildingId);

	/**
	 * 由主键查找对象
	 * 
	 * @param announcementId
	 * @return
	 */
	@Select("select * from announcement where announcement_id=#{announcementId}")
	@ResultMap("com.dormitory.mapper.AnnouncementMapper.announcement")
	public Announcement get(@Param("announcementId") Integer announcementId);

	/**
	 * 返回最近插入的主键，无插入时返回0，必须在插入后调用
	 * 
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
	@Insert(" insert into announcement(title,content,img_path,author_id,create_time,importance) "
			+ " values(#{title},#{content},#{imgPath},#{authorId},#{createTime},#{importance}) ")
	@Options(useGeneratedKeys = true, keyProperty = "announcementId")
	public void save(Announcement announcement);

	/**
	 * 修改
	 * 
	 * @param announcement
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	@Update(" update announcement set title=#{title},content=#{content}, "
			+ " img_path=#{imgPath},author_id=#{authorId},importance=#{importance} "
			+ " where announcement_id=#{announcementId} ")
	public void update(Announcement announcement);

	/**
	 * 删除
	 * 
	 * @param announcementId
	 * @author guo.junbao
	 * @date 2017-4-12
	 */
	@Delete("delete from announcement where announcement_id=#{announcementId} ")
	public void remove(Announcement announcement);
	
	

}