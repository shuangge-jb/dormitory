package test.dormitory.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.dormitory.controller.AnnouncementController;
import com.dormitory.controller.admin.AdminController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class AnnouncementControllerTest {
	@Resource
	private AnnouncementController announcementController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(announcementController).build();
	}

	@Test
	public void testListAnnouncement() {
		try {
			ResultActions result = mockMvc.perform(get("/listAnnouncement.do").param("pageIndex", "1")
					.param("pageSize", "1").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
					.andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListAnnouncementLimit() {
		try {
			ResultActions result = mockMvc.perform(get("/listAnnouncementLimit.do").param("n", "1")
					.accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
					.andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetAnnouncement() {
		try {
			ResultActions result = mockMvc.perform(get("/getAnnouncement.do").param("announcementId", "1")
					.accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
					.andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
