package test.dormitory.controller.master;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dormitory.controller.AnnouncementController;
import com.dormitory.controller.admin.AdminAnnouncementController;
import com.dormitory.controller.master.MasterAnnouncementController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class MasterAnnouncementControllerTest {
	@Resource
	private MasterAnnouncementController masterAnnouncementController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(masterAnnouncementController).build();
	}

	@Test
	public void testSaveOrUpdateAnnouncement() {
		try {
			File file = new File("D://图片/发票.jpg");
			mockMvc.perform(fileUpload("/master/saveOrUpdateAnnouncement.do")
					.file(new MockMultipartFile("img","发票.jpg","image/jpeg", new FileInputStream(file))).param("title", "水表")
					.param("content", "查水表").param("authorId", "1").param("createTime", format.format(new Date()))
					.param("importance", "1")).andExpect(status().isOk()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSaveOrUpdateAnnouncementImgNull() {
		try {
			mockMvc.perform(fileUpload("/master/saveOrUpdateAnnouncement.do")
					.file(new MockMultipartFile("img","发票.jpg","image/jpeg", new byte[]{})).param("title", "水表")
					.param("content", "查水表").param("authorId", "1").param("createTime", format.format(new Date()))
					.param("importance", "1")).andExpect(status().isOk()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRemoveAnnouncement() {
		try {

			// URI uri = new URI("file:/dormitory/models/1.jpg");
			mockMvc.perform(post("/master/removeAnnouncement.do")
					.param("announcementId", "6")
					).andExpect(status().isOk()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testRemoveAnnouncementNotExisted() {
		try {

			// URI uri = new URI("file:/dormitory/models/1.jpg");
			mockMvc.perform(post("/master/removeAnnouncement.do")
					.param("announcementId", "10")
					).andExpect(status().isOk()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
