package test.dormitory.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.Dormitory;
import com.dormitory.service.ElectricityService;
import com.dormitory.service.dto.ElectricityDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class ElectricityServiceImplTest {
	@Resource
	private ElectricityService electricityService;

	@Test
	public void testGetElectricity() {
		Integer dormitoryId = 1;
		Double restElectricity = new Double("100.00");
		Double sumElectricity = new Double("300.00");
		Double balance = new Double("60.00");
		ElectricityDTO electricity = electricityService
				.getElectricity(dormitoryId);
		assertNotNull(electricity);
		assertEquals(restElectricity, electricity.getRestElectricity());
		assertEquals(sumElectricity, electricity.getSumElectricity());
		assertEquals(balance, electricity.getBalance());
		System.out.println(electricity);
	}

}
