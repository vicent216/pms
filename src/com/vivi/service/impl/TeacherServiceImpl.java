package com.vivi.service.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.vivi.dao.TeacherDao;
import com.vivi.dao.impl.TeacherDaoImpl;
import com.vivi.domain.Person;
import com.vivi.domain.Teacher;
import com.vivi.service.TeacherService;
import com.vivi.util.ComparatorUtil;

public class TeacherServiceImpl implements TeacherService {
	TeacherDao dao = new TeacherDaoImpl();

	public boolean addTeacher(Teacher stu) {
		Boolean result = false;
		Teacher check = dao.findTeacherById(stu.getNum());
		if (check == null) {
			result = dao.addTeacher(stu);
		}
		return result;
	}

	public boolean deleteTeacher(String num) {
		boolean result = false;
		Teacher check = dao.findTeacherById(num);
		if (check != null) {
			result = dao.deleteTeacherById(num);
		}
		return result;
	}

	public List<Teacher> findTeacher(String attr, String str) {
		return dao.findTeacherByAttr(attr, str);
	}

	public boolean updateTeacher(Teacher stu, String num) {
		boolean result = false;
		Teacher check = dao.findTeacherById(num);
		if ((check != null) && (num == stu.getNum())) {
			dao.deleteTeacherById(num);
			result = dao.addTeacher(stu);
		}
		return result;
	}

	public boolean insertTeacher(Teacher stu, String pos) {
		boolean result = false;
		Teacher check = dao.findTeacherById(stu.getNum());
		if (check == null) {
			result = dao.insertTeacher(stu, Integer.parseInt(pos));
		}
		return result;
	}

	public List<Teacher> showTeachers() {
		return dao.showTeachers();
	}

	public List<Teacher> sortTeachers(String attr, int i) {
		List<Teacher> teachers = dao.showTeachers();
		
		Collections.sort(teachers, ComparatorUtil.makeComparator(attr));
		
		return teachers;
	}

	public void saveTeachers(List<Teacher> teachers) {
		dao.saveTeachers(teachers);

	}

}
