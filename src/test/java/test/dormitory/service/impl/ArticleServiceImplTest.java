package test.dormitory.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.Article;
import com.dormitory.service.ArticleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mybatis.xml" })

public class ArticleServiceImplTest {
	@Autowired
	private ArticleService articleService;

	private void init() {
		Article article = new Article();
		article.setDormitoryId(1);
		article.setName("台灯");
		article.setStudentId(201330610505L);
		articleService.saveOrUpdate(article);
	}
	@Transactional
	@Test
	public void testGet() {
	System.out.println("testGet");
		init();
		Article article = articleService.get(articleService.getLastInsertId());
		System.out.println(article);
		assertEquals("台灯", article.getName());
	}
	@Transactional
	@Test
	public void testSave() {
		
		
	}
	@Transactional
	@Test
	public void testUpdate() {
		init();
		Article article = articleService.get(articleService.getLastInsertId());
		String newName="小台灯";
		article.setName(newName);
		articleService.saveOrUpdate(article);
	}
	@Transactional
	@Test
	public void testRemove() {
		init();
		Article article = articleService.get(articleService.getLastInsertId());
		articleService.remove(article);
		Article afterRemove=articleService.get(articleService.getLastInsertId());
		assertNull(afterRemove);
	}
	@Transactional
	@Test
	public void testListByDormitoryId() {
		init();
		List<Article> list=articleService.listByDormitoryId(1);
		assertEquals(1, list.size());
	}

}
