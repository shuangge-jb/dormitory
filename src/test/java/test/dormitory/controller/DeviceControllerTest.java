package test.dormitory.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dormitory.controller.DeviceController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class DeviceControllerTest {
	@Resource
	private DeviceController deviceController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(deviceController).build();

	}

	@Test
	public void testListDevice() {
		try {
			mockMvc.perform(get("/listDevice.do").param("pageIndex", "1").param("pageSize", "1"))
					.andExpect(status().isOk()).andExpect(view().name("dormitory")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListInterfaceByDeviceId() {
		fail("Not yet implemented");
	}

	@Test
	public void testListParamByInterfaceId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDevice() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInterface() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetParamater() {
		fail("Not yet implemented");
	}

}
