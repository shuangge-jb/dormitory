package test.dormitory.controller.student;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dormitory.controller.student.StudentController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class StudentControllerTest {
	@Resource
	private StudentController studentController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
	}

	@Test
	public void testRegister() {
		try {
			File file = new File("D://图片/发票.jpg");
			mockMvc.perform(fileUpload("/student/register.do")
					.file(new MockMultipartFile("img", "头像.jpg", "jpeg/jpg", new FileInputStream(file)))
					.param("studentId", "201334523458").param("bedId", "3").param("name", "主席")
					.param("phoneNumber", "18812345678").param("email", "1123456789@qq.com").param("password", "654321")
					.param("password2", "654321").param("buildingName", "c4").param("room", "145"))
					.andExpect(status().isOk()).andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testRegisterExisted() {
		try {
			File file = new File("D://图片/发票.jpg");
			mockMvc.perform(fileUpload("/student/register.do")
					.file(new MockMultipartFile("img", "头像.jpg", "jpeg/jpg", new FileInputStream(file)))
					.param("studentId", "201334523456").param("bedId", "3").param("name", "主席")
					.param("phoneNumber", "18812345678").param("email", "1123456789@qq.com").param("password", "654321")
					.param("password2", "654321").param("buildingName", "c4").param("room", "145"))
					.andExpect(status().isOk()).andExpect(view().name("../../reg")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testLogin() {
		try {
			mockMvc.perform(post("/student/studentLogin.do").param("id", "201334523456").param("password", "654321"))
					.andExpect(status().isOk()).andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLoginError() {
		try {
			mockMvc.perform(post("/student/studentLogin.do").param("id", "201334523456").param("password", "65432"))
					.andExpect(status().isOk()).andExpect(view().name("../../jsp/login")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdatePassword() {
		try {
			mockMvc.perform(
					post("/student/updatePassword.do").param("studentId", "201334523456").param("password", "654321"))
					.andExpect(status().isOk()).andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetStudentInfo() {
		try {
			mockMvc.perform(get("/student/getStudentInfo.do").param("studentId", "201334523456"))
					.andExpect(status().isOk()).andExpect(view().name("")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateStudentInfo() {
		try {
			ResultActions result = mockMvc
					.perform(MockMvcRequestBuilders.fileUpload("/student/updateStudentInfo.do")
							.file(new MockMultipartFile("img", "", "", new byte[] {}))
							.param("studentId", "201334523456").param("bedId", "4").param("name", "老王")
							.param("phoneNumber", "13489023456").param("email", "1122234567@qq.com")
							.param("password", "123456").param("buildingName", "c10").param("room", "510"))
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

}
