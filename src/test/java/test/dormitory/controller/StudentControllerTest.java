package test.dormitory.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import javax.annotation.Resource;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dormitory.student.controller.StudentController;

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
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();

	}

	@Test
	public void testRegister() {
		try {
			mockMvc.perform(post("/student/register").param("building", "C1").param("room", "102").param("name", "长者")
					.param("email", "1121162882@qq.com").param("phoneNumber", "13245678901")
					.param("studentId", "201330612345").param("bedId", "5").param("password", "123456")
					.param("password2", "123456")).andExpect(status().is(302))
					.andExpect(view().name("redirect:/student")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testLogin() {
		try {
			mockMvc.perform(post("/student/login").param("name", "长者").param("password", "123456"))
					.andExpect(status().is(302)).andExpect(view().name("redirect:/student")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testIsStudentIdExisted() {
		try {
			mockMvc.perform(get("/student/isStudentIdExisted").param("studentId", "201330610505").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().is(200)).andExpect(content().string("existed")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testIsPasswordCorrect() {
		try {
			mockMvc.perform(get("/student/isPasswordCorrect").param("studentId", "201330610505").param("password", "123456").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().is(200)).andExpect(content().string("correct")).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testUpdatePassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindPassword() {
		fail("Not yet implemented");
	}

}
