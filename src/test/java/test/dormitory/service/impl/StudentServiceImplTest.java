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
		
	}
	@Test
	public void testGetStudent() {
		Long studentId=201330610505L;
		Integer dormitoryId=1;
		Integer bedId=2;
		String name="爽哥";
		Long phoneNumber=13925094598L;
		String email="562559243@qq.com";
		String password="950824";
		Student student=studentService.getStudent(studentId);
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
	public void testUpdatePassword(){
		System.out.println("testUpdatePassword");
		Long studentId=201330610505L;
		Student student=studentService.getStudent(studentId);
		String password="950824";
		student.setPassword(password);
		studentService.updatePassword(student);
		Student newStudent=studentService.getStudent(studentId);
		assertNotNull(newStudent);
		assertEquals(password, newStudent.getPassword());
	}

}
