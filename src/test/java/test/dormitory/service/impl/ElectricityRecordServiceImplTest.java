package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.ElectricityRecord;
import com.dormitory.service.ElectricityRecordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class ElectricityRecordServiceImplTest {
	@Resource
	private ElectricityRecordService electricityRecordService;

	@Test
	public void testListElectricityRecord() {
		Integer dormitoryId = 1;
		List<ElectricityRecord> records = electricityRecordService
				.listElectricityRecord(dormitoryId);
		assertNotNull(records);
		assertEquals(2, records.size());
		for (ElectricityRecord item : records) {
			System.out.println(item);
		}
	}

}
