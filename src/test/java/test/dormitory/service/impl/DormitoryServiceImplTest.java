package test.dormitory.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.Dormitory;
import com.dormitory.service.DormitoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class DormitoryServiceImplTest {
	@Autowired
	private DormitoryService dormitoryService;

	@Test
	public void testGetDormitory() {
		Integer dormitoryId=1;
		String building="C10";
		String room="512";
		Dormitory dormitory = dormitoryService.getDormitory(dormitoryId);
		assertNotNull(dormitory);
		assertEquals(new Integer(1), dormitory.getDormitoryId());
		assertEquals(building, dormitory.getBuilding());
		assertEquals(room, dormitory.getRoom());
		System.out.println(dormitory);
	}

}
