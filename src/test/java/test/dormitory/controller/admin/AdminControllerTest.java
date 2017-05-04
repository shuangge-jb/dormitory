package test.dormitory.controller.admin;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

import com.dormitory.controller.admin.AdminController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class AdminControllerTest {
	@Resource
	private AdminController adminController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();

	}

	@Test
	public void testLogin() {
		try {
			mockMvc.perform(post("/admin/login.do").param("name", "admin").param("password", "admin"))
					.andExpect(view().name("adminMain")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListMaster() {
		try {
			ResultActions result = mockMvc.perform(get("/admin/listMaster.do").param("pageIndex", "1")
					.param("pageSize", "1").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
			String str = result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON result:" + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSaveMaster() {
		try {
			ResultActions result = mockMvc
					.perform(post("/admin/saveMaster.do").param("name", "laowanga")
							.param("phoneNumber", "18812345678").param("email", "612237891@qq.com")
							.param("password", "890987").param("buildingName", "c6"))
					.andExpect(view().name("")).andDo(print());
			String str = result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON result:" + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateMaster() {
		try {
			ResultActions result = mockMvc
					.perform(post("/admin/updateMaster.do").param("masterId", "8").param("name", "laowanga")
							.param("phoneNumber", "13312345678").param("email", "612237891@qq.com")
							.param("password", "890987").param("buildingName", "c6"))
					.andExpect(view().name("")).andDo(print());
			String str = result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON result:" + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdateMasterNotExisted() {
		try {
			ResultActions result = mockMvc
					.perform(post("/admin/updateMaster.do").param("masterId", "10").param("name", "laowanga")
							.param("phoneNumber", "13312345678").param("email", "612237891@qq.com")
							.param("password", "890987").param("buildingName", "c6"))
					.andExpect(view().name("error")).andDo(print());
			String str = result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON result:" + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testRemoveMaster() {
		try {
			ResultActions result = mockMvc
					.perform(post("/admin/removeMaster.do").param("masterId", "8"))
					.andExpect(view().name("")).andDo(print());
			String str = result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON result:" + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testRemoveMasterNotExisted() {
		try {
			ResultActions result = mockMvc
					.perform(post("/admin/removeMaster.do").param("masterId", "10"))
					.andExpect(view().name("")).andDo(print());
			String str = result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON result:" + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testRemoveStudent() {
		try {
			ResultActions result = mockMvc
					.perform(post("/admin/removeStudent.do").param("studentId", "201420323456"))
					.andExpect(view().name("")).andDo(print());
			String str = result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON result:" + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testRemoveStudentNotExisted() {
		try {
			ResultActions result = mockMvc
					.perform(post("/admin/removeStudent.do").param("studentId", "201420323458"))
					.andExpect(view().name("")).andDo(print());
			String str = result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON result:" + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
