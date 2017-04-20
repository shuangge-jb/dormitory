package test.dormitory.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.Administrator;
import com.dormitory.entity.Article;
import com.dormitory.service.AdministratorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mybatis.xml" })

public class AdministratorServiceImplTest {
	@Autowired
	private AdministratorService administratorService;

	private void init() {
		System.out.println("init");
		Administrator administrator = new Administrator();
		administrator.setEmail("1121162882@qq.com");
		administrator.setName("楼管");
		administrator.setPassword("123456");
		administratorService.saveOrUpdate(administrator);
	}
	@Transactional
	@Test
	public void testSave() {
		System.out.println("testSave");
		init();
		Administrator administrator = administratorService.get(administratorService.getLastInsertId());
		System.out.println(administrator);
		assertEquals("1121162882@qq.com", administrator.getEmail());
	}
	@Transactional
	@Test
	public void testUpdate() {
		System.out.println("testUpdate");
		init();
		Integer id=administratorService.getLastInsertId();
		Administrator administrator = administratorService.get(id);
		String newName="新楼管";
		administrator.setName(newName);
		administratorService.saveOrUpdate(administrator);
		System.out.println(administrator);
		assertEquals(newName, administrator.getName());
	}
	@Transactional
	@Test
	public void testRemove() {
		System.out.println("testRemove");
		init();
		Integer id=administratorService.getLastInsertId();
		Administrator before = administratorService.get(id);
		administratorService.remove(before);
		Administrator after = administratorService.get(id);
		assertEquals(null, after);
	}

}
