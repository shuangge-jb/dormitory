package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.Announcement;
import com.dormitory.service.AnnouncementService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class AnnouncementServiceImplTest {
	@Resource
	private AnnouncementService announcementServiceImpl;

	@Test
	public void testListAnnouncementLimit() {
		Integer n = new Integer(2);
		List<Announcement> list = announcementServiceImpl.listAnnouncementLimit(n);
		assertNotNull(list);
		assertEquals(2, list.size());
	}
	@Test
	public void testListAnnouncement() {
		List<Announcement> list = announcementServiceImpl.listAnnouncement();
		assertNotNull(list);
		assertEquals(3, list.size());
	}
}
