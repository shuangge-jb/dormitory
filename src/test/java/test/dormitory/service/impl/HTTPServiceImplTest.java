package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.service.HTTPService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class HTTPServiceImplTest {
@Resource 
private HTTPService httpService;
	@Test
	public void testDoGetStringMapOfStringObject() {
		Map<String,Object>map=new HashMap<String,Object>(3);
		map.put("building", "C10");
		map.put("room", "512");
		String result=httpService.doGet("http://110.64.88.226:8080/electricity/getElectricity.do", map);
		System.out.println("result="+result);
	}

	@Test
	public void testDoPostSSLStringMapOfStringObject() {
		
	}

}
