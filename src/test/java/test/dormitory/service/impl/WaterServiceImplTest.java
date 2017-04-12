package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.service.WaterService;
import com.dormitory.service.dto.WaterDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class WaterServiceImplTest {
	@Resource
	private WaterService waterService;

	@Test
	public void testGetWater() {
		Integer dormitoryId = 1;
		String building = "C10";
		String room = "512";
		Long readout = 999L;
		BigDecimal price = new BigDecimal("130.00");
		WaterDTO waterDTO = waterService.getWater(dormitoryId);
		assertNotNull(waterDTO);
		assertEquals(building, waterDTO.getBuilding());
		assertEquals(room, waterDTO.getRoom());
		assertEquals(readout, waterDTO.getReadout());
		assertEquals(price, waterDTO.getPrice());
		System.out.println(waterDTO);
	}

}
