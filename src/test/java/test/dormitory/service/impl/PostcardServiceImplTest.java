package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.dormitory.entity.Announcement;
import com.dormitory.entity.Postcard;
import com.dormitory.service.PostcardService;
@Service
public class PostcardServiceImplTest {
@Resource
private PostcardService postcardService;
private void init(){
	
}
	@Test
	public void testListPostcard() {
		for (int i = 0; i < 3; i++) {
			Postcard temp = new Postcard();
			temp.setCreateTime(new Timestamp(System.currentTimeMillis()));
			temp.setDormitoryId(new Integer(1));
			temp.setStudentId(new Long(201330610505L));
			temp.setState(new Integer(1));
			postcardService.savePostcard(temp);
		}
	}

	@Test
	public void testListPostcardLimit() {
		init();
		List<Postcard> list=postcardService.listPostcardLimit(new Integer(2));
		assertNotNull(list);
		assertEquals(2, list.size());
		for (Postcard item : list) {
			System.out.println(item);
		}
	}

	

	@Test
	public void testSavePostcard() {
		
	}

	@Test
	public void testUpdatePostcard() {
		
	}

	@Test
	public void testRemovePostcard() {
		
	}

}
