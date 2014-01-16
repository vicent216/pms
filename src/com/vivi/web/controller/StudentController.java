package com.vivi.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.vivi.domain.Student;
import com.vivi.service.StudentService;
import com.vivi.service.impl.StudentServiceImpl;
import com.vivi.util.FormBeanUtil;
import com.vivi.web.formbean.StudentFormBean;

public class StudentController extends HttpServlet {
	StudentService s = new StudentServiceImpl();
	private String result = "";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String operation = request.getParameter("operation");
		try {

			if ("add".equals(operation)) {
				add(request, response);
			} else if ("update".equals(operation)) {
				update(request, response);
			} else if ("delete".equals(operation)) {
				delete(request, response);
			} else if ("find".equals(operation)) {
				find(request, response);
			} else if ("sort".equals(operation)) {
				sort(request, response);
			} else if ("save".equals(operation)) {
				save(request, response);
			} else {
				List<Student> students = s.showStudents();
				show(request, response, students);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		request.getRequestDispatcher(result).forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		List<Student> students = (List<Student>) request.getSession().getAttribute("save");
		if(students != null) {
			s.saveStudents(students);
		}
		students = s.showStudents();
		show(request, response, students);
//		request.getSession().removeAttribute("save");
	}

	private void sort(HttpServletRequest request, HttpServletResponse response) {
		String attr = request.getParameter("attr");
		List<Student> students = s.sortStudents(attr, 0);
		show(request, response, students);
	}

	private void find(HttpServletRequest request, HttpServletResponse response) {
		String attr = request.getParameter("attr");
		String str = request.getParameter("str");
		List<Student> students = new ArrayList<Student>();
		if (str == null || "".equals(str)) {
			students = s.showStudents();
			show(request, response, students);
		} else {
			students = s.findStudent(attr, str);
			show(request, response, students);
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		s.deleteStudent(num);
		response.setHeader("Refresh", "2;URL=" + request.getContextPath()
				+ "/servlet/StudentController");
		request.setAttribute("message", "删除成功！2秒后自动转向学生管理界面。");
		result = "/META-INF/pages/message.jsp";
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String num = request.getParameter("num");
		if (request.getParameter("first") != null) {
			Student stu = s.findStudent("num", num).get(0);
			StudentFormBean stuF = new StudentFormBean();
			BeanUtils.copyProperties(stuF, stu);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			String sDate = df.format(stu.getBirth());
			stuF.setBirth(sDate);
			request.setAttribute("formBean", stuF);

			result = "/META-INF/pages/updateStudent.jsp";
		} else {
			request.removeAttribute("formBean");
			StudentFormBean formBean = FormBeanUtil.fillFormBean(request,
					StudentFormBean.class);
			if (!formBean.validate()) {
				request.setAttribute("formBean", formBean);
				result = "/META-INF/pages/updateStudent.jsp";
			} else {
				Student stu = new Student();
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(stu, formBean);
				s.updateStudent(stu, num);
				response.setHeader("Refresh",
						"2;URL=" + request.getContextPath()
								+ "/servlet/StudentController");
				request.setAttribute("message", "保存成功！2秒后自动转向学生管理界面。");
				result = "/META-INF/pages/message.jsp";
			}
		}

	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("first") != null) {
			result = "/META-INF/pages/addStudent.jsp";
		} else {
			StudentFormBean formBean = FormBeanUtil.fillFormBean(request,
					StudentFormBean.class);
			if (!formBean.validate()) {
				request.setAttribute("formBean", formBean);
				result = "/META-INF/pages/addStudent.jsp";
			} else {
				Student stu = new Student();
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(stu, formBean);
				s.addStudent(stu);
				response.setHeader("Refresh",
						"2;URL=" + request.getContextPath()
								+ "/servlet/StudentController");
				request.setAttribute("message", "保存成功！2秒后自动转向学生管理界面。");
				result = "/META-INF/pages/message.jsp";
			}
		}

	}

	private void show(HttpServletRequest request, HttpServletResponse response, List<Student> students) {
		List<StudentFormBean> studentsF = new LinkedList<StudentFormBean>();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Student stu = new Student();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			for (int i = 0; i < students.size(); i++) {
				StudentFormBean stuF = new StudentFormBean();
				stu = students.get(i);
				BeanUtils.copyProperties(stuF, stu);
				String sDate = df.format(stu.getBirth());
				stuF.setBirth(sDate);
				studentsF.add(stuF);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		request.setAttribute("students", studentsF);
		request.getSession().setAttribute("save", students);
		result = "/META-INF/pages/student.jsp";
	}

}
