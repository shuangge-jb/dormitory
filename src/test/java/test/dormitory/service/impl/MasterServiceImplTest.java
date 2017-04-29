package test.dormitory.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.Master;
import com.dormitory.entity.Device;
import com.dormitory.service.MasterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mybatis.xml" })

public class MasterServiceImplTest {
	@Autowired
	private MasterService masterService;

	private void init() {
		System.out.println("init");
		Master administrator = new Master();
		administrator.setEmail("1121162882@qq.com");
		administrator.setName("楼管");
		administrator.setPassword("123456");
		masterService.saveOrUpdate(administrator);
	}
	@Transactional
	@Test
	public void testSave() {
		System.out.println("testSave");
		init();
		Master administrator = masterService.get(masterService.getLastInsertId());
		System.out.println(administrator);
		assertEquals("1121162882@qq.com", administrator.getEmail());
	}
	@Transactional
	@Test
	public void testUpdate() {
		System.out.println("testUpdate");
		init();
		Integer id=masterService.getLastInsertId();
		Master administrator = masterService.get(id);
		String newName="新楼管";
		administrator.setName(newName);
		masterService.saveOrUpdate(administrator);
		System.out.println(administrator);
		assertEquals(newName, administrator.getName());
	}
	@Transactional
	@Test
	public void testRemove() {
		System.out.println("testRemove");
		init();
		Integer id=masterService.getLastInsertId();
		Master before = masterService.get(id);
		masterService.remove(before);
		Master after = masterService.get(id);
		assertEquals(null, after);
	}

}
