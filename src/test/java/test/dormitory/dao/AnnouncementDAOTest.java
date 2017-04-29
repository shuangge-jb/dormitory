package test.dormitory.dao;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.dao.AnnouncementDAO;
import com.dormitory.entity.Announcement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
@Transactional
public class AnnouncementDAOTest {
	@Resource
	private AnnouncementDAO announcementDAO;

	@Test
	public void testGetAnnouncementExist() {
		Announcement announcement = announcementDAO
				.get(new Integer(1));
		assertNotNull(announcement);
		System.out.println(announcement);
	}

	@Test
	public void testGetAnnouncementUnExist() {
		Announcement announcement = announcementDAO
				.get(new Integer(5));
		assertNull(announcement);
	}

	@Test
	public void testGetAnnouncementIdNull() {
		Announcement announcement = announcementDAO.get(null);
		assertNull(announcement);
	}

	@Test
	public void testSaveAnnouncement() {
		Announcement announcement = new Announcement();
		announcement.setAnnouncementId(announcementDAO
				.getLastInsertId());// existed
		announcement.setContent("通知");
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		announcement.setCreateTime(timestamp);
		//announcement.setState(new Integer(1));
		announcementDAO.save(announcement);
		Integer newid = announcementDAO.getLastInsertId();
		System.out.println(newid);
		assertEquals(newid, announcement.getAnnouncementId());
	}
	@Test
	public void testGetLastInsertId(){
		System.out.println(announcementDAO.getLastInsertId());
	}
	

}
