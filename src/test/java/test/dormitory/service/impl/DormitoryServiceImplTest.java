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
		Long studentId=201330610505L;
		Integer buildingId=10;
		String room="512";
		Dormitory dormitory = dormitoryService.get(studentId);
		assertNotNull(dormitory);
		assertEquals(new Integer(1), dormitory.getDormitoryId());
		assertEquals(buildingId, dormitory.getBuildingId());
		assertEquals(room, dormitory.getRoom());
		System.out.println(dormitory);
	}

}
