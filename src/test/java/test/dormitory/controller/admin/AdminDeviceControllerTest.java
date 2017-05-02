package test.dormitory.controller.admin;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dormitory.controller.admin.AdminDeviceController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class AdminDeviceControllerTest {
	@Resource
	private AdminDeviceController adminDeviceController;
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(adminDeviceController).build();

	}

	@Test
	public void testSaveOrUpdateDevice() {

	}

	@Test
	public void testRemoveDevice() {
		try {
			mockMvc.perform(get("/admin/removeDevice.do").param("deviceId", "19")).andExpect(status().isOk())
					.andExpect(view().name("dormitory")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveOrUpdateInterface() {
		try {
			mockMvc.perform(post("/admin/saveOrUpdateInterface.do").param("interfaceName", "查看本月电费")
					.param("interfaceUrl", "localhost:8080/electricity/getElectricity.do").param("description", "本月电费")
					.param("source", "电费系统").param("method", "get")).andExpect(status().isOk())
					.andExpect(view().name("dormitory")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveInterface() {
		try {
			mockMvc.perform(get("/admin/removeInterface.do").param("interfaceId", "1")).andExpect(status().isOk())
					.andExpect(view().name("dormitory")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveOrUpdateParamater() {
		try {
			mockMvc.perform(post("/admin/saveOrUpdateParamater.do").param("paramaterName", "楼号")
					.param("description", "宿舍楼的编号").param("type", "1").param("interfaceId", "2"))
					.andExpect(status().isOk()).andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveParamater() {
		try {
			mockMvc.perform(post("/admin/removeParamater.do").param("paramaterId", "1")).andExpect(status().isOk())
					.andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
