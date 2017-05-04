package test.dormitory.controller.repair;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.dormitory.controller.RepairRecordController;
import com.dormitory.controller.repair.RepairController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class RepairControllerTest {
	@Resource
	private RepairController repairController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(repairController).build();
	}

	@Test
	public void testLogin() {
		try {
			ResultActions result = mockMvc
					.perform(post("/repair/repairLogin.do").param("name", "repair").param("password", "repair"))
					.andExpect(status().isOk()).andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListRepairRecord() {
		try {
			ResultActions result = mockMvc.perform(post("/repair/listRepairRecord.do").param("pageIndex", "1")
					.param("pageSize", "1").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
					.andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateRepairRecord() {
		try {
			ResultActions result = mockMvc
					.perform(post("/repair/updateRepairRecord.do").param("name", "repair").param("password", "repair"))
					.andExpect(status().isOk()).andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
