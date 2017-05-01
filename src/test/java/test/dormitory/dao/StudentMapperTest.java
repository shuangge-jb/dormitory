package test.dormitory.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.dao.StudentDAO;
import com.dormitory.entity.Student;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
"classpath:spring-mybatis.xml" })  
public class StudentMapperTest{
	@Autowired
private StudentDAO studentDAO;
	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByPrimaryKey() {
		Student student=studentDAO.get(201330610505L);
		assertNotNull(student);
		assertEquals("爽哥", student.getName());
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}
	@Test
	public void testListByBuildingId(){
		List<Student> list=studentDAO.list(1, 1);
		System.out.println("list size:"+list.size());
	}
}
