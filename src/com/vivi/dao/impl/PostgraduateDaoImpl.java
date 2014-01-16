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

import com.vivi.dao.PostgraduateDao;
import com.vivi.dao.TeacherDao;
import com.vivi.domain.Postgraduate;
import com.vivi.domain.Teacher;
import com.vivi.exception.PostgraduateDaoException;
import com.vivi.util.Dom4JUtil;

public class PostgraduateDaoImpl implements PostgraduateDao {
	
	private String res = "postgraduates.xml";
	TeacherDao dao = new TeacherDaoImpl();
	
	public boolean addPostgraduate(Postgraduate stu) {

		Boolean result = false;
		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String sDate = df.format(stu.getBirth());
			
			String tea = null;
			if(stu.getTeacher() == null) {
				tea = null;
			} else {
				tea = stu.getTeacher().getNum();
			}
			
			root.addElement("postgraduate")
			    .addAttribute("num", stu.getNum())
			    .addAttribute("name", stu.getName())
			    .addAttribute("gender", stu.getGender())
			    .addAttribute("birth", sDate)
			    .addAttribute("idCard", stu.getIdCard())
			    .addAttribute("classNum", stu.getClassNum())
			    .addAttribute("major", stu.getMajor())
			    .addAttribute("teacher", tea);
			
			Dom4JUtil.write2xml(doc, res);
			
			result = true;
		} catch (Exception e) {
			throw new PostgraduateDaoException(e);
		}
		return result;
	}

	public boolean deletePostgraduateById(String num) {

		Boolean result = false;
		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//postgraduate[@num='"+num+"']";
			
			Node node = doc.selectSingleNode(xPath);
			if (node != null) {
				root.remove(node);
				Dom4JUtil.write2xml(doc, res);
				result = true;
			}
		} catch (Exception e) {
			throw new PostgraduateDaoException(e);
		}
		return result;
	}

	public Postgraduate findPostgraduateById(String num) {

		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//postgraduate[@num='"+num+"']";
			Node node = doc.selectSingleNode(xPath);		

			if (node != null) {
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birth = df.parse(node.valueOf("@birth"));
				
				Postgraduate stu = new Postgraduate();
				stu.setNum(node.valueOf("@num"));
				stu.setName(node.valueOf("@name"));
				stu.setGender(node.valueOf("@gender"));
				stu.setBirth(birth);
				stu.setIdCard(node.valueOf("@idCard"));
				stu.setClassNum(node.valueOf("@classNum"));
				stu.setMajor(node.valueOf("@major"));
				stu.setTeacher(dao.findTeacherById(node.valueOf("@teacher")));
				
				return stu;
			}
			
		} catch (Exception e) {
			throw new PostgraduateDaoException(e);
		}
		return null;
	}

	public List<Postgraduate> showPostgraduates() {

		try {
			
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//postgraduate";
			List<Element> nodes = doc.selectNodes(xPath);		
			List<Postgraduate> postgraduates = new ArrayList<Postgraduate>();

			for (Iterator iter = nodes.iterator(); iter.hasNext(); ) {
				Element node = (Element) iter.next();
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birth = df.parse(node.valueOf("@birth"));
				
				Postgraduate stu = new Postgraduate();
				stu.setNum(node.valueOf("@num"));
				stu.setName(node.valueOf("@name"));
				stu.setGender(node.valueOf("@gender"));
				stu.setBirth(birth);
				stu.setIdCard(node.valueOf("@idCard"));
				stu.setClassNum(node.valueOf("@classNum"));
				stu.setMajor(node.valueOf("@major"));
				stu.setTeacher(dao.findTeacherById(node.valueOf("@teacher")));
				postgraduates.add(stu);
				
			}
			return postgraduates;
			
		} catch (Exception e) {
			throw new PostgraduateDaoException(e);
		}
	}

	public boolean savePostgraduates(List<Postgraduate> postgraduates) {

		Boolean result = false;
		try {
//			Document doc = Dom4JUtil.getDocument(res);
//			Element root = doc.getRootElement();
			Document doc = DocumentHelper.createDocument();
			Element root = doc.addElement("postgraduates");
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			for (Postgraduate stu : postgraduates) {
				String tea = null;
				if(stu.getTeacher() == null) {
					tea = null;
				} else {
					tea = stu.getTeacher().getNum();
				}
				
				
				String sDate = df.format(stu.getBirth());
				root.addElement("postgraduate").addAttribute("num", stu.getNum())
						.addAttribute("name", stu.getName())
						.addAttribute("gender", stu.getGender())
						.addAttribute("birth", sDate)
						.addAttribute("idCard", stu.getIdCard())
						.addAttribute("classNum", stu.getClassNum())
						.addAttribute("major", stu.getMajor())
					    .addAttribute("teacher", tea);
			}
			Dom4JUtil.write2xml(doc, res);
			
			result = true;
		} catch (Exception e) {
			throw new PostgraduateDaoException(e);
		}
		return result;
	}

	public boolean insertPostgraduate(Postgraduate stu, int pos) {
		Boolean result = false;
		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			Element stuE = DocumentHelper.createElement("postgraduate");
			List<Element> children = root.elements();
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String sDate = df.format(stu.getBirth());
			
			String tea = null;
			if(stu.getTeacher() == null) {
				tea = null;
			} else {
				tea = stu.getTeacher().getNum();
			}
			
			
			stuE.addAttribute("num", stu.getNum())
			    .addAttribute("name", stu.getName())
			    .addAttribute("gender", stu.getGender())
			    .addAttribute("birth", sDate)
			    .addAttribute("idCard", stu.getIdCard())
			    .addAttribute("classNum", stu.getClassNum())
			    .addAttribute("major", stu.getMajor())
			    .addAttribute("teacher", tea);
			
			children.add(pos, stuE);
			Dom4JUtil.write2xml(doc, res);
			
			result = true;
		} catch (Exception e) {
			throw new PostgraduateDaoException(e);
		}
		return result;
	}

	public List<Postgraduate> findPostgraduateByAttr(String attr, String str) {

		try {
			Document doc = Dom4JUtil.getDocument(res);
			Element root = doc.getRootElement();
			String xPath = "//postgraduate[@"+attr+"='"+str+"']";
			List<Element> nodes = doc.selectNodes(xPath);		
			List<Postgraduate> postgraduates = new ArrayList<Postgraduate>();

			for (Iterator iter = nodes.iterator(); iter.hasNext(); ) {
				Element node = (Element) iter.next();
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date birth = df.parse(node.valueOf("@birth"));
				
				Postgraduate stu = new Postgraduate();
				stu.setNum(node.valueOf("@num"));
				stu.setName(node.valueOf("@name"));
				stu.setGender(node.valueOf("@gender"));
				stu.setBirth(birth);
				stu.setIdCard(node.valueOf("@idCard"));
				stu.setClassNum(node.valueOf("@classNum"));
				stu.setMajor(node.valueOf("@major"));
				stu.setTeacher(dao.findTeacherById(node.valueOf("@teacher")));
				postgraduates.add(stu);
				
			}
			return postgraduates;
			
			
		} catch (Exception e) {
			throw new PostgraduateDaoException(e);
		}
	}

}
