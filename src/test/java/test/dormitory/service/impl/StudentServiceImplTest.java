package test.dormitory.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dormitory.entity.Student;
import com.dormitory.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mybatis.xml" })
public class StudentServiceImplTest {
	@Resource
	private StudentService studentService;

	private void init(){
		Student student=new Student();
		student.setStudentId(201330612345L);
		student.setBedId(1);
		student.setDormitoryId(1);
		student.setEmail("13925094598@163.com");
		student.setName("震惊");
		student.setPassword("1234567890");
		student.setPhoneNumber(13925023456L);
		studentService.saveOrUpdate(student);
	}
	@Test
	public void testGetStudent() {
		Long studentId=201330610505L;
		Integer dormitoryId=1;
		Integer bedId=2;
		String name="爽哥";
		Long phoneNumber=13925094598L;
		String email="562559243@qq.com";
		String password="123456";
		Student student=studentService.get(studentId);
		assertNotNull(student);
		assertEquals(studentId, student.getStudentId());
		assertEquals(dormitoryId, student.getDormitoryId());
		assertEquals(bedId, student.getBedId());
		assertEquals(name, student.getName());
		assertEquals(phoneNumber, student.getPhoneNumber());
		assertEquals(email, student.getEmail());
		assertEquals(password, student.getPassword());
		System.out.println(student);
	}
	@Transactional
	@Test
	public void testSave(){
		System.out.println("testSave");
		init();
		Student student=studentService.get(201330612345L);
		System.out.println(student);
		assertEquals("震惊", student.getName());
	}
	@Transactional
	@Test
	public void testUpdate(){
		System.out.println("testUpdatePassword");
		Long studentId=201330610505L;
		Student student=studentService.get(studentId);
		String password="950824";
		student.setPassword(password);
		studentService.saveOrUpdate(student);
		Student newStudent=studentService.get(studentId);
		assertNotNull(newStudent);
		assertEquals(password, newStudent.getPassword());
	}

}
