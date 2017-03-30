package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.WaterRecord;
import com.dormitory.service.WaterRecordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class WaterRecordServiceImplTest {
	@Resource
	private WaterRecordService waterRecordService;

	@Test
	public void testListWaterRecord() {
		Integer dormitoryId = 1;
		List<WaterRecord> records = waterRecordService
				.listWaterRecord(dormitoryId);
		assertNotNull(records);
		assertEquals(2, records.size());
		for (WaterRecord item : records) {
			System.out.println(item);
		}
	}

}
