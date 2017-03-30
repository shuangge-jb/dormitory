package test.dormitory.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.dao.CampusCardDAO;
import com.dormitory.entity.CampusCard;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class CampusCardMapperTest {
	@Autowired
	private CampusCardDAO campusCardMapper;

	@Test
	public void testSelectByStudentId() {
		Long studentId=201330610505L;
		CampusCard card = campusCardMapper.getCampusCard(studentId);
		System.out.println(card);
		assertNotNull(card);
		assertEquals(new Integer(1), card.getCampusCardId());
		assertEquals(studentId, card.getStudentId());
		assertEquals(new BigDecimal("200.00"), card.getCardBalance());
		assertEquals(new BigDecimal("10.00"), card.getHotwaterBalance());
	}

}
