package com.vivi.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.vivi.dao.PostgraduateDao;
import com.vivi.dao.TeacherDao;
import com.vivi.dao.impl.PostgraduateDaoImpl;
import com.vivi.dao.impl.TeacherDaoImpl;
import com.vivi.domain.Postgraduate;
import com.vivi.domain.Teacher;

public class PostDaoTest {
	PostgraduateDao dao = new PostgraduateDaoImpl();

	@Test
	public void test() {
		Postgraduate post = new Postgraduate();
		post.setNum("000");
		post.setBirth(new Date());
		assertTrue(dao.addPostgraduate(post));
	}
	
	@Test
	public void test1() {
		Postgraduate post = new Postgraduate();
		post.setNum("000");
		post.setBirth(new Date());
		
		Teacher tea = new Teacher();
		tea.setNum("001");
		tea.setBirth(new Date());
		
		post.setTeacher(tea);
		
		assertTrue(dao.addPostgraduate(post));
	}
	
	@Test
	public void test2() {
		
		TeacherDao tDao = new TeacherDaoImpl();
		
		Postgraduate post = dao.findPostgraduateById("001");
		
		System.out.print(post);
		
	}

}
