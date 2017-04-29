package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.Device;
import com.dormitory.service.DeviceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mybatis.xml" })

public class DeviceServiceImplTest {
	@Autowired
	private DeviceService articleService;

	private void init() {
		Device article = new Device();
		article.setDormitoryId(1);
		article.setName("台灯");
		article.setStudentId(201330610505L);
		articleService.saveOrUpdate(article);
	}
	@Transactional
	@Test
	public void testGet() {
	System.out.println("testGet");
		init();
		Device article = articleService.get(articleService.getLastInsertId());
		System.out.println(article);
		assertEquals("台灯", article.getName());
	}
	@Transactional
	@Test
	public void testSave() {
		
		
	}
	@Transactional
	@Test
	public void testUpdate() {
		init();
		Device article = articleService.get(articleService.getLastInsertId());
		String newName="小台灯";
		article.setName(newName);
		articleService.saveOrUpdate(article);
	}
	@Transactional
	@Test
	public void testRemove() {
		init();
		Device article = articleService.get(articleService.getLastInsertId());
		articleService.remove(article);
		Device afterRemove=articleService.get(articleService.getLastInsertId());
		assertNull(afterRemove);
	}
	@Transactional
	@Test
	public void testListByDormitoryId() {
		init();
		List<Device> list=articleService.listByDormitoryId(1);
		assertEquals(1, list.size());
	}

}
