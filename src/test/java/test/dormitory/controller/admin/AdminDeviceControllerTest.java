package test.dormitory.controller.admin;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
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
		try {
			File file = new File("D://图片/发票.jpg");
			mockMvc.perform(fileUpload("/admin/saveOrUpdateDevice.do")
					.file(new MockMultipartFile("img", "发票.jpg", "image/jpeg", new FileInputStream(file)))
					.file(new MockMultipartFile("model", "模型.dae", "image/jpeg", new byte[] {})).param("name", "水表1")
					.param("type", "宿舍共有").param("description", "水费系统")).andExpect(status().isOk()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Test
	public void testRemoveDevice() {
		try {
			mockMvc.perform(get("/admin/removeDevice.do").param("deviceId", "23").param("pageIndex", "1")
					.param("pageSize", "10")).andExpect(status().isOk())
					.andExpect(view().name("forward:/listDevice.do")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveOrUpdateInterfaceConflict() {
		try {
			mockMvc.perform(post("/admin/saveOrUpdateInterface.do").param("interfaceName", "查看本月电费")
					.param("interfaceUrl", "localhost:8080/electricity/getElectricity.do").param("description", "本月电费")
					.param("source", "电费系统").param("method", "get").param("deviceId", "14")).andExpect(status().isOk())
					.andExpect(view().name("error")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveOrUpdateInterfaceUrl() {
		try {
			mockMvc.perform(post("/admin/saveOrUpdateInterface.do").param("interfaceName", "查看本月电费")
					.param("interfaceUrl", "localhost:8080/electricity/getElectricity.do").param("description", "本月电费")
					.param("source", "电费系统").param("method", "get").param("deviceId", "14")).andExpect(status().isOk())
					.andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Test
	public void testRemoveInterface() {
		try {
			mockMvc.perform(get("/admin/removeInterface.do").param("interfaceId", "5")).andExpect(status().isOk())
					.andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveOrUpdateParamaterBuilding() {
		try {
			mockMvc.perform(post("/admin/saveOrUpdateParamater.do").param("paramaterName", "building")
					.param("description", "宿舍楼的编号").param("type", "string").param("interfaceId", "3"))
					.andExpect(status().isOk()).andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveOrUpdateParamaterRoom() {
		try {
			mockMvc.perform(post("/admin/saveOrUpdateParamater.do").param("paramaterName", "room")
					.param("description", "宿舍房间的编号").param("type", "integer").param("interfaceId", "3"))
					.andExpect(status().isOk()).andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveOrUpdateParamaterDateTime() {
		try {
			mockMvc.perform(post("/admin/saveOrUpdateParamater.do").param("paramaterName", "createTime")
					.param("description", "创建时间").param("type", "datetime").param("interfaceId", "3"))
					.andExpect(status().isOk()).andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Test
	public void testRemoveParamater() {
		try {
			mockMvc.perform(post("/admin/removeParamater.do").param("paramaterId", "10")).andExpect(status().isOk())
					.andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
