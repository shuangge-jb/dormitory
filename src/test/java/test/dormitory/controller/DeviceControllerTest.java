package test.dormitory.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dormitory.controller.DeviceController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mvc.xml", "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class DeviceControllerTest {
	@Resource
	private DeviceController deviceController;
	@Resource
	private WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		mockMvc = MockMvcBuilders.standaloneSetup(deviceController).build();

	}

	@Test
	public void testListDevice() {
		try {
			ResultActions result = mockMvc.perform(get("/listDevice.do").param("pageIndex", "1").param("pageSize", "1"))
					.andExpect(status().isOk()).andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListInterfaceByDeviceId() {
		try {
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/listInterfaceByDeviceId.do")
					.param("deviceId", "14").param("pageIndex", "1").param("pageSize", "1")).andExpect(status().isOk())
					.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListParamByInterfaceId() {
		try {
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/listParamByInterfaceId.do")
					.param("deviceId", "14").param("interfaceId", "3").param("pageIndex", "1").param("pageSize", "10"))
					.andExpect(status().isOk()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetDevice() {
		try {
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/getDevice.do").param("deviceId", "14"))
					.andExpect(status().isOk()).andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetInterface() {
		try {
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/getInterface.do")
					.param("interfaceId", "2").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
					.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetParamater() {
		try {
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/getParamater.do")
					.param("paramaterId", "2").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
					.andDo(print());
			String content = result.andReturn().getResponse().getContentAsString();
			System.out.println("return :" + content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testListDeviceJSON(){
		try {
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/listDeviceJSON.do")
					.accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
					.andDo(print());
			String str=result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON result:"+str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testlistFunctionByDeviceIdJSON(){
		try {
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/listFunctionByDeviceIdJSON.do")
					.param("deviceId", "14").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
					.andDo(print());
			String str=result.andReturn().getResponse().getContentAsString();
			System.out.println("JSON result:"+str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testListAllParam(){
		try {
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/listAllParam.do")
					.param("pageIndex", "1").param("pageSize", "10")).andExpect(status().isOk())
					.andDo(print());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
