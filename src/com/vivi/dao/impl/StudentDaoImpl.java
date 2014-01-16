package com.vivi.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.vivi.dao.StudentDao;
import com.vivi.domain.Student;
import com.vivi.exception.StudentDaoException;
import com.vivi.util.Dom4JUtil;

public class StudentDaoImpl implements StudentDao {
	
	private String res = "students.xml";
	public boolean addStudent(Student stu) {

		Boolean result = false;
		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String sDate = df.format(stu.getBirth());
			
			root.addElement("student")
			    .addAttribute("num", stu.getNum())
			    .addAttribute("name", stu.getName())
			    .addAttribute("gender", stu.getGender())
			    .addAttribute("birth", sDate)
			    .addAttribute("idCard", stu.getIdCard())
			    .addAttribute("classNum", stu.getClassNum());
			
			Dom4JUtil.write2xml(doc, res);
			
			result = true;
		} catch (Exception e) {
			throw new StudentDaoException(e);
		}
		return result;
	}

	public boolean deleteStudentById(String num) {

		Boolean result = false;
		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//student[@num='"+num+"']";
			
			Node node = doc.selectSingleNode(xPath);
			if (node != null) {
				root.remove(node);
				Dom4JUtil.write2xml(doc, res);
				result = true;
			}
		} catch (Exception e) {
			throw new StudentDaoException(e);
		}
		return result;
	}

	public Student findStudentById(String num) {

		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//student[@num='"+num+"']";
			Node node = doc.selectSingleNode(xPath);		

			if (node != null) {
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birth = df.parse(node.valueOf("@birth"));
				
				Student stu = new Student();
				stu.setNum(node.valueOf("@num"));
				stu.setName(node.valueOf("@name"));
				stu.setGender(node.valueOf("@gender"));
				stu.setBirth(birth);
				stu.setIdCard(node.valueOf("@idCard"));
				stu.setClassNum(node.valueOf("@classNum"));
				
				return stu;
			}
			
		} catch (Exception e) {
			throw new StudentDaoException(e);
		}
		return null;
	}

	public List<Student> showStudents() {

		try {
			
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//student";
			List<Element> nodes = doc.selectNodes(xPath);		
			List<Student> students = new ArrayList<Student>();

			for (Iterator iter = nodes.iterator(); iter.hasNext(); ) {
				Element node = (Element) iter.next();
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birth = df.parse(node.valueOf("@birth"));
				
				Student stu = new Student();
				stu.setNum(node.valueOf("@num"));
				stu.setName(node.valueOf("@name"));
				stu.setGender(node.valueOf("@gender"));
				stu.setBirth(birth);
				stu.setIdCard(node.valueOf("@idCard"));
				stu.setClassNum(node.valueOf("@classNum"));
				students.add(stu);
				
			}
			return students;
			
		} catch (Exception e) {
			throw new StudentDaoException(e);
		}
	}

	public boolean saveStudents(List<Student> students) {

		Boolean result = false;
		try {
//			Document doc = Dom4JUtil.getDocument(res);
//			Element root = doc.getRootElement();
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("students");
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			for (Student stu : students) {
				String sDate = df.format(stu.getBirth());
				root.addElement("student").addAttribute("num", stu.getNum())
						.addAttribute("name", stu.getName())
						.addAttribute("gender", stu.getGender())
						.addAttribute("birth", sDate)
						.addAttribute("idCard", stu.getIdCard())
						.addAttribute("classNum", stu.getClassNum());
			}
			Dom4JUtil.write2xml(doc, res);
			
			result = true;
		} catch (Exception e) {
			throw new StudentDaoException(e);
		}
		return result;
	}

	public boolean insertStudent(Student stu, int pos) {
		Boolean result = false;
		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			Element stuE = DocumentHelper.createElement("student");
			List<Element> children = root.elements();
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String sDate = df.format(stu.getBirth());
			
			stuE.addAttribute("num", stu.getNum())
			    .addAttribute("name", stu.getName())
			    .addAttribute("gender", stu.getGender())
			    .addAttribute("birth", sDate)
			    .addAttribute("idCard", stu.getIdCard())
			    .addAttribute("classNum", stu.getClassNum());
			
			children.add(pos, stuE);
			Dom4JUtil.write2xml(doc, res);
			
			result = true;
		} catch (Exception e) {
			throw new StudentDaoException(e);
		}
		return result;
	}

	public List<Student> findStudentByAttr(String attr, String str) {

		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//student[@"+attr+"='"+str+"']";
			List<Element> nodes = doc.selectNodes(xPath);		
			List<Student> students = new ArrayList<Student>();

			for (Iterator iter = nodes.iterator(); iter.hasNext(); ) {
				Element node = (Element) iter.next();
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birth = df.parse(node.valueOf("@birth"));
				
				Student stu = new Student();
				stu.setNum(node.valueOf("@num"));
				stu.setName(node.valueOf("@name"));
				stu.setGender(node.valueOf("@gender"));
				stu.setBirth(birth);
				stu.setIdCard(node.valueOf("@idCard"));
				stu.setClassNum(node.valueOf("@classNum"));
				students.add(stu);
				
			}
			return students;
			
			
		} catch (Exception e) {
			throw new StudentDaoException(e);
		}
	}

}
