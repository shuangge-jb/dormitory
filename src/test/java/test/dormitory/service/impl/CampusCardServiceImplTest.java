package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.CampusCard;
import com.dormitory.service.CampusCardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class CampusCardServiceImplTest {
	@Resource
	private CampusCardService campusCardService;

	@Test
	public void testGetCampusCard() {
		Long studentId=201330610505L;
		Integer campusCardId=1;
		BigDecimal cardBalance=new BigDecimal("200.00");
		BigDecimal hotwaterBalance=new BigDecimal("10.00");
		CampusCard card=campusCardService.getCampusCard(studentId);
		assertNotNull(card);
		assertEquals(campusCardId, card.getCampusCardId());
		assertEquals(studentId, card.getStudentId());
		assertEquals(cardBalance, card.getCardBalance());
		assertEquals(hotwaterBalance, card.getHotwaterBalance());
		System.out.println(card);
	}

}
