package test.dormitory.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dormitory.controller.DeviceController;
import com.dormitory.controller.RepairRecordController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class RepairRecordControllerTest {
	@Resource
	private RepairRecordController repairRecordController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(repairRecordController).build();

	}

	@Test
	public void testListRepairRecord() {
		try {
			ResultActions result = mockMvc.perform(get("/listRepairRecord.do").param("pageIndex", "1")
					.param("pageSize", "1").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
					.andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListRepairRecordLimit() {
		try {
			ResultActions result = mockMvc
					.perform(get("/listRepairRecordLimit.do").param("n", "1").accept(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(status().isOk()).andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetRepiarRecord() {
		try {
			ResultActions result = mockMvc.perform(
					get("/getRepairRecord.do").param("repairRecordId", "1").accept(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(status().isOk()).andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveRepairRecord() {
		try {
			ResultActions result = mockMvc
					.perform(post("/saveRepairRecord.do").param("dormitoryId", "1").param("deviceName", "空调")
							.param("content", "空调不凉").param("price", "0").param("state", "1")
							.param("contactId", "201330610505").accept(MediaType.APPLICATION_JSON_UTF8))
					.andExpect(status().isOk()).andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveRepairRecord() {
		try {
			ResultActions result = mockMvc.perform(post("/removeRepairRecord.do").param("repairRecordId", "1"))
					.andExpect(status().isOk()).andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
