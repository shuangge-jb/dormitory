package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.NetworkRecord;
import com.dormitory.service.NetworkRecordService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class NetworkRecordServiceImplTest {
	@Resource
	private NetworkRecordService networkRecordService;

	@Test
	public void testListNetworkRecord() {
		Long studentId = 201330610505L;
		List<NetworkRecord> records = networkRecordService
				.listNetworkRecord(studentId);
		assertNotNull(records);
		assertEquals(2, records.size());
		for (NetworkRecord item : records) {
			System.out.println(item);
		}
	}

}
