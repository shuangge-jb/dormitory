package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.dto.PostcardDTO;
import com.dormitory.entity.Announcement;
import com.dormitory.entity.Postcard;
import com.dormitory.service.PostcardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mybatis.xml" })
public class PostcardServiceImplTest {
	@Resource
	private PostcardService postcardService;

	private void init() {
		for (int i = 0; i < 3; i++) {
			Postcard temp = new Postcard();
			temp.setCreateTime(new Timestamp(System.currentTimeMillis()));
			temp.setDormitoryId(new Integer(1));
			temp.setStudentId(new Long(201330610505L));
			temp.setState(new Integer(1));
			postcardService.saveOrUpdate(temp);
		}
	}

	@Test
	public void testListPostcard() {

	}

	@Test
	public void testListPostcardLimit() {
		init();
		List<PostcardDTO> list = postcardService.listLimit(2);
		assertNotNull(list);
		assertEquals(2, list.size());
		for (Postcard item : list) {
			System.out.println(item);
		}
	}

	@Transactional
	@Test
	public void testSavePostcard() {

	}

	@Transactional
	@Test
	public void testUpdatePostcard() {

	}

	@Transactional
	@Test
	public void testRemovePostcard() {

	}

}
