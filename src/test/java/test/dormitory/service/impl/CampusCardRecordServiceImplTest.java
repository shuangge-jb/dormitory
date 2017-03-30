package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.CampusCardRecord;
import com.dormitory.service.CampusCardRecordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class CampusCardRecordServiceImplTest {
	@Resource
	private CampusCardRecordService campusCardRecordService;

	@Test
	public void testListCampusCardRecord() {
		Long studentId = 201330610505L;
		List<CampusCardRecord> records = campusCardRecordService
				.listCampusCardRecord(studentId);
		assertNotNull(records);
		assertEquals(2, records.size());
		for (CampusCardRecord item : records) {
			System.out.println(item);
		}
	}

}
