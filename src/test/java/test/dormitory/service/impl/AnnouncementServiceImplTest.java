package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.dormitory.entity.Announcement;
import com.dormitory.service.AnnouncementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
@Transactional
public class AnnouncementServiceImplTest {
	@Resource
	private AnnouncementService announcementServiceImpl;

	
	public void init() {
		for (int i = 0; i < 3; i++) {
			Announcement temp = new Announcement();
			temp.setContent("通知" + (i + 1));
			temp.setCreateTime(new Timestamp(System.currentTimeMillis()));
			temp.setState(new Integer(1));
			announcementServiceImpl.saveAnnouncement(temp);
		}
	}

	@Test
	public void testListAnnouncementLimit() {
		init();
		System.out.println("testListAnnouncementLimit:");
		Integer n = new Integer(2);
		List<Announcement> list = announcementServiceImpl
				.listAnnouncementLimit(n);
		assertNotNull(list);
		assertEquals(2, list.size());
		for (Announcement item : list) {
			System.out.println(item);
		}
	}

	@Test
	public void testListAnnouncement() {
		init();
		System.out.println("testListAnnouncement:");
		List<Announcement> list = announcementServiceImpl.listAnnouncement();
		assertNotNull(list);
		assertEquals(3, list.size());
		for (Announcement item : list) {
			System.out.println(item);
		}
	}

	@Test
	public void testSaveAnnouncementKeyNull() {
		System.out.println("testSaveAnnouncementKeyNull:");
		Announcement announcement = new Announcement();
		announcement.setAnnouncementId(null);//key null
		announcement.setContent("通知");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		announcement.setCreateTime(timestamp);
		announcement.setState(new Integer(1));
		assertNull(null, announcement.getAnnouncementId());
		Announcement result = announcementServiceImpl
				.saveAnnouncement(announcement);
		assertNotNull(result);
		System.out.println(result);
		assertEquals(
				announcementServiceImpl.getLastInsertId(),
				result.getAnnouncementId());
	}

	@Test
	public void testSaveAnnouncementExist() {
		init();
		System.out.println("testSaveAnnouncementExist:");
		Announcement announcement = new Announcement();
		announcement.setAnnouncementId(new Integer(announcementServiceImpl.getLastInsertId()));// existed
		announcement.setContent("通知");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		announcement.setCreateTime(timestamp);
		announcement.setState(new Integer(1));
		Announcement result = announcementServiceImpl
				.saveAnnouncement(announcement);
		assertNotNull(result);
		System.out.println(result);
		assertEquals(announcementServiceImpl.getLastInsertId(), result.getAnnouncementId());
	}

	@Test
	public void testSaveAnnouncementUnExist() {
		System.out.println("testSaveAnnouncementUnExist:");
		Announcement announcement = new Announcement();
		announcement.setAnnouncementId(new Integer(-1));// unexisted
		announcement.setContent("通知4");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		announcement.setCreateTime(timestamp);
		announcement.setState(new Integer(1));
		Announcement result = announcementServiceImpl
				.saveAnnouncement(announcement);
		System.out.println(result);
		assertNotNull(result);
		assertEquals(announcementServiceImpl.getLastInsertId(), result.getAnnouncementId());
	}
	
	@Test
	public void testGetLastInsertId(){
		System.out.println(announcementServiceImpl.getLastInsertId());
	}
}
