package test.dormitory.controller.master;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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
import com.dormitory.controller.master.MasterController;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class MasterControllerTest {
	@Resource
	private MasterController masterController;
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(masterController).build();
	}
	@Test
	public void testLogin() {
		try {
			mockMvc.perform(post("/master/masterLogin.do").param("id", "1").param("password", "123456")).andExpect(status().isOk())
					.andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdatePassword() {
		try {
			mockMvc.perform(post("/master/updateMasterPassword.do").param("masterId", "1").param("password", "123456")).andExpect(status().isOk())
					.andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPersonalInfo() {
		try {
			mockMvc.perform(get("/master/getMasterInfo.do").param("masterId", "1")).andExpect(status().isOk())
					.andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveStudent() {
		try {
			mockMvc.perform(post("/master/removeStudent.do").param("studentId", "201521123456")).andExpect(status().isOk())
					.andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
