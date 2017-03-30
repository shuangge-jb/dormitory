package test.dormitory.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.Network;
import com.dormitory.service.NetworkService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class NetworkServiceImplTest {
	@Resource
	private NetworkService networkService;

	@Test
	public void testGetNetwork() {
		Long studentId = 201330610505L;
		String tariffPackage = "包学期";
		Integer money = 120;
		Network network = networkService.getNetwork(studentId);
		assertNotNull(network);
		assertEquals(studentId, network.getSutdentId());
		assertEquals(tariffPackage, network.getTariffPackage());
		assertEquals(money, network.getMoney());
		System.out.println(network);
	}

}
