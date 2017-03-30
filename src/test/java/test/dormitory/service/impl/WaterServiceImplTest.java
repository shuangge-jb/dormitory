package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.Water;
import com.dormitory.service.WaterService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class WaterServiceImplTest {
	@Resource
	private WaterService waterService;

	@Test
	public void testGetWater() {
		Integer dormitoryId = 1;
		Long prevReadout = 1000L;
		Long thisReadout = 1999L;
		Water water = waterService.getWater(dormitoryId);
		assertNotNull(water);
		assertEquals(dormitoryId, water.getDormitoryId());
		assertEquals(prevReadout, water.getPrevReadout());
		assertEquals(thisReadout, water.getThisReadout());
		System.out.println(water);
	}

}
