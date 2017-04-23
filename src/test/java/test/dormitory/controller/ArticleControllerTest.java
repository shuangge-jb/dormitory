package test.dormitory.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;

import static org.hamcrest.Matchers.equalTo;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dormitory.student.controller.ArticleController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class ArticleControllerTest {
	@Resource
	private ArticleController articleController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();

	}

	@Test
	public void testSaveArticle() {

		try {
			// URI uri = new URI("file:/dormitory/models/1.jpg");
			File file = new File("D://图片/发票.jpg");
			mockMvc.perform(
					fileUpload("/student/article/saveArticle").file(new MockMultipartFile("file", new FileInputStream(file)))
							.param("name", "灯").param("dormitoryId", "1").param("studentId", "201330610505"))
					.andExpect(view().name("error")).andDo(print());
			// .andExpect(print().string(equalTo("success")));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
