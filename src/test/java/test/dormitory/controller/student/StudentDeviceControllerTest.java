package test.dormitory.controller.student;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dormitory.controller.admin.AdminDeviceController;
import com.dormitory.controller.student.StudentDeviceController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class StudentDeviceControllerTest {
	@Resource
	private StudentDeviceController studentDeviceController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(studentDeviceController).build();
	}
	@Test
	public void testInvokeInterfaceUnExisted() {
		try {
			ResultActions result = mockMvc
					.perform(MockMvcRequestBuilders.post("/student/invokeInterface.do").param("interfaceId", "2")
							.param("building", "C10").param("room", "510"))
					.andExpect(status().isOk());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON return :" + content);
			assertNotNull(content);
			assertTrue(content.isEmpty());
			assertTrue(content.equals(""));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testInvokeInterfaceDateTime() {
		try {
			ResultActions result = mockMvc
					.perform(MockMvcRequestBuilders.post("/student/invokeInterface.do").param("interfaceId", "3")
							.param("building", "c10").param("room", "512").param("createTime", "2017-1-10:0:0"))
					.andExpect(status().isOk());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON return :" + content);
			assertNotNull(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testListFunctionByDeviceIdLike(){
		try {
			ResultActions result = mockMvc
					.perform(MockMvcRequestBuilders.get("/student/listFunctionByDeviceIdLike.do").param("deviceId", "14")
							.param("keyword", "电费").param("pageIndex", "1").param("pageSize", "10"))
					.andExpect(status().isOk()).andDo(print());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
