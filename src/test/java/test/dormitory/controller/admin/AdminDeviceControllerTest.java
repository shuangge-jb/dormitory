package test.dormitory.controller.admin;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class AdminDeviceControllerTest {

	@Test
	public void testSaveOrUpdateDevice() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveDevice() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveOrUpdateInterface() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveInterface() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveOrUpdateParamater() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveParamater() {
		fail("Not yet implemented");
	}

}
