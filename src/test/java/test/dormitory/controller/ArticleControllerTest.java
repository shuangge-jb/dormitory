package test.dormitory.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dormitory.controller.ArticleController;

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
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();
		
	}

	@Test
	public void testSaveArticle() {
		try {
			 URI uri=new URI("D:/图片/发票.jpg");
			 request.setParameter("name", "灯");
			mockMvc.perform(fileUpload("/article/saveArticle", uri)).andExpect(status().isOk())
					.andExpect(content().string(equalTo("success")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
