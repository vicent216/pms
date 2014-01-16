package com.vivi.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.vivi.domain.Student;
import com.vivi.service.StudentService;
import com.vivi.service.impl.StudentServiceImpl;

public class StudentServiceTest {
	private StudentService s = new StudentServiceImpl();
	Student stu = new Student();
	@Test
	public void test() {
		stu.setNum("001");
		assertFalse(s.addStudent(stu));

	}
	@Test
	public void test1() {

		stu.setNum("004");
		stu.setBirth(new Date());
		assertTrue(s.addStudent(stu));
	}
	@Test
	public void test2() {

		assertTrue(s.deleteStudent("004"));
	}
	

}
