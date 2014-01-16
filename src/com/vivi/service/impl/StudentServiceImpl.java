package com.vivi.service.impl;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.vivi.dao.StudentDao;
import com.vivi.dao.impl.StudentDaoImpl;
import com.vivi.domain.Person;
import com.vivi.domain.Student;
import com.vivi.service.StudentService;
import com.vivi.util.ComparatorUtil;

public class StudentServiceImpl implements StudentService {
	StudentDao dao = new StudentDaoImpl();

	public boolean addStudent(Student stu) {
		Boolean result = false;
		Student check = dao.findStudentById(stu.getNum());
		if (check == null) {
			result = dao.addStudent(stu);
		}
		return result;
	}

	public boolean deleteStudent(String num) {
		boolean result = false;
		Student check = dao.findStudentById(num);
		if (check != null) {
			result = dao.deleteStudentById(num);
		}
		return result;
	}

	public List<Student> findStudent(String attr, String str) {
		return dao.findStudentByAttr(attr, str);
	}

	public boolean updateStudent(Student stu, String num) {
		boolean result = false;
		Student check = dao.findStudentById(num);
		if ((check != null) && (num == stu.getNum())) {
			dao.deleteStudentById(num);
			result = dao.addStudent(stu);
		}
		return result;
	}

	public boolean insertStudent(Student stu, String pos) {
		boolean result = false;
		Student check = dao.findStudentById(stu.getNum());
		if (check == null) {
			result = dao.insertStudent(stu, Integer.parseInt(pos));
		}
		return result;
	}

	public List<Student> showStudents() {
		return dao.showStudents();
	}

	public List<Student> sortStudents(String attr, int i) {
		List<Student> students = dao.showStudents();
		
		Collections.sort(students, ComparatorUtil.makeComparator(attr));
		
		return students;
	}

	public void saveStudents(List<Student> students) {
		dao.saveStudents(students);

	}

}
