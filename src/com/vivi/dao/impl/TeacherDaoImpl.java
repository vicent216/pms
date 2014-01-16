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

import com.vivi.dao.TeacherDao;
import com.vivi.domain.Teacher;
import com.vivi.exception.TeacherDaoException;
import com.vivi.util.Dom4JUtil;

public class TeacherDaoImpl implements TeacherDao {
	
	private String res = "teachers.xml";
	public boolean addTeacher(Teacher stu) {

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
			    .addAttribute("job", stu.getJob())
			    .addAttribute("depart", stu.getDepart());
			
			Dom4JUtil.write2xml(doc, res);
			
			result = true;
		} catch (Exception e) {
			throw new TeacherDaoException(e);
		}
		return result;
	}

	public boolean deleteTeacherById(String num) {

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
			throw new TeacherDaoException(e);
		}
		return result;
	}

	public Teacher findTeacherById(String num) {

		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//student[@num='"+num+"']";
			Node node = doc.selectSingleNode(xPath);		

			if (node != null) {
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birth = df.parse(node.valueOf("@birth"));
				
				Teacher stu = new Teacher();
				stu.setNum(node.valueOf("@num"));
				stu.setName(node.valueOf("@name"));
				stu.setGender(node.valueOf("@gender"));
				stu.setBirth(birth);
				stu.setIdCard(node.valueOf("@idCard"));
				stu.setJob(node.valueOf("@job"));
				
				return stu;
			}
			
		} catch (Exception e) {
			throw new TeacherDaoException(e);
		}
		return null;
	}

	public List<Teacher> showTeachers() {

		try {
			
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//student";
			List<Element> nodes = doc.selectNodes(xPath);		
			List<Teacher> teachers = new ArrayList<Teacher>();

			for (Iterator iter = nodes.iterator(); iter.hasNext(); ) {
				Element node = (Element) iter.next();
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birth = df.parse(node.valueOf("@birth"));
				
				Teacher stu = new Teacher();
				stu.setNum(node.valueOf("@num"));
				stu.setName(node.valueOf("@name"));
				stu.setGender(node.valueOf("@gender"));
				stu.setBirth(birth);
				stu.setIdCard(node.valueOf("@idCard"));
				stu.setJob(node.valueOf("@job"));
				stu.setDepart(node.valueOf("@depart"));
				teachers.add(stu);
				
			}
			return teachers;
			
		} catch (Exception e) {
			throw new TeacherDaoException(e);
		}
	}

	public boolean saveTeachers(List<Teacher> teachers) {

		Boolean result = false;
		try {
//			Document doc = Dom4JUtil.getDocument(res);
//			Element root = doc.getRootElement();
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("teachers");
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			for (Teacher stu : teachers) {
				String sDate = df.format(stu.getBirth());
				root.addElement("student").addAttribute("num", stu.getNum())
						.addAttribute("name", stu.getName())
						.addAttribute("gender", stu.getGender())
						.addAttribute("birth", sDate)
						.addAttribute("idCard", stu.getIdCard())
						.addAttribute("job", stu.getJob())
						.addAttribute("depart", stu.getDepart());
			}
			Dom4JUtil.write2xml(doc, res);
			
			result = true;
		} catch (Exception e) {
			throw new TeacherDaoException(e);
		}
		return result;
	}

	public boolean insertTeacher(Teacher stu, int pos) {
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
			    .addAttribute("job", stu.getJob())
			    .addAttribute("depart", stu.getDepart());
			
			children.add(pos, stuE);
			Dom4JUtil.write2xml(doc, res);
			
			result = true;
		} catch (Exception e) {
			throw new TeacherDaoException(e);
		}
		return result;
	}

	public List<Teacher> findTeacherByAttr(String attr, String str) {

		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//student[@"+attr+"='"+str+"']";
			List<Element> nodes = doc.selectNodes(xPath);		
			List<Teacher> teachers = new ArrayList<Teacher>();

			for (Iterator iter = nodes.iterator(); iter.hasNext(); ) {
				Element node = (Element) iter.next();
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birth = df.parse(node.valueOf("@birth"));
				
				Teacher stu = new Teacher();
				stu.setNum(node.valueOf("@num"));
				stu.setName(node.valueOf("@name"));
				stu.setGender(node.valueOf("@gender"));
				stu.setBirth(birth);
				stu.setIdCard(node.valueOf("@idCard"));
				stu.setJob(node.valueOf("@job"));
				stu.setDepart(node.valueOf("@depart"));
				teachers.add(stu);
				
			}
			return teachers;
			
			
		} catch (Exception e) {
			throw new TeacherDaoException(e);
		}
	}

}
