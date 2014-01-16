package com.vivi.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.vivi.dao.StudentDao;
import com.vivi.dao.impl.StudentDaoImpl;
import com.vivi.domain.Student;
import com.vivi.service.StudentService;
import com.vivi.service.impl.StudentServiceImpl;

public class StudentDaoTest {
	StudentDao dao = new StudentDaoImpl();
	@Test
	public void test() {
		
		Student stu = new Student();
		stu.setNum("001");
		stu.setBirth(new Date());
		assertTrue(dao.addStudent(stu));
	}
	@Test
	public void test1() {
		StudentDao dao = new StudentDaoImpl();
		Student stu = new Student();
		stu.setNum("002");
		stu.setBirth(new Date());
		assertTrue(dao.insertStudent(stu, 0));
	}
	
	@Test
	public void test2() {
		assertTrue(dao.deleteStudentById("002"));
	}
	
	
	
	@Test
	public void test4() {
		List stus = dao.showStudents();
		System.out.println(stus);
	}
	@Test
	public void test3() {
		StudentService s = new StudentServiceImpl();
		Student stu = new Student();
		stu.setNum("001");
		stu.setName("hahaha1");
		stu.setBirth(new Date());
		s.updateStudent(stu, "001");
	}




}
