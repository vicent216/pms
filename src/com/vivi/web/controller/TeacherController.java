package com.vivi.web.controller;

import java.io.IOException;
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

import com.vivi.domain.Teacher;
import com.vivi.service.TeacherService;
import com.vivi.service.impl.TeacherServiceImpl;
import com.vivi.util.FormBeanUtil;
import com.vivi.web.formbean.TeacherFormBean;

public class TeacherController extends HttpServlet {
	TeacherService s = new TeacherServiceImpl();
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
				List<Teacher> teachers = s.showTeachers();
				show(request, response, teachers);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		request.getRequestDispatcher(result).forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		List<Teacher> teachers = (List<Teacher>) request.getSession().getAttribute("save");
		if(teachers != null) {
			s.saveTeachers(teachers);
		}
		teachers = s.showTeachers();
		show(request, response, teachers);
//		request.getSession().removeAttribute("save");
	}

	private void sort(HttpServletRequest request, HttpServletResponse response) {
		String attr = request.getParameter("attr");
		List<Teacher> teachers = s.sortTeachers(attr, 0);
		show(request, response, teachers);
	}

	private void find(HttpServletRequest request, HttpServletResponse response) {
		String attr = request.getParameter("attr");
		String str = request.getParameter("str");
		List<Teacher> teachers = new ArrayList<Teacher>();
		if (str == null || "".equals(str)) {
			teachers = s.showTeachers();
			show(request, response, teachers);
		} else {
			teachers = s.findTeacher(attr, str);
			show(request, response, teachers);
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		s.deleteTeacher(num);
		response.setHeader("Refresh", "2;URL=" + request.getContextPath()
				+ "/servlet/TeacherController");
		request.setAttribute("message", "删除成功！2秒后自动转向教师管理界面。");
		result = "/META-INF/pages/message.jsp";
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String num = request.getParameter("num");
		if (request.getParameter("first") != null) {
			Teacher stu = s.findTeacher("num", num).get(0);
			TeacherFormBean stuF = new TeacherFormBean();
			BeanUtils.copyProperties(stuF, stu);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			String sDate = df.format(stu.getBirth());
			stuF.setBirth(sDate);
			request.setAttribute("formBean", stuF);

			result = "/META-INF/pages/updateTeacher.jsp";
		} else {
			request.removeAttribute("formBean");
			TeacherFormBean formBean = FormBeanUtil.fillFormBean(request,
					TeacherFormBean.class);
			if (!formBean.validate()) {
				request.setAttribute("formBean", formBean);
				result = "/META-INF/pages/updateTeacher.jsp";
			} else {
				Teacher stu = new Teacher();
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(stu, formBean);
				s.updateTeacher(stu, num);
				response.setHeader("Refresh",
						"2;URL=" + request.getContextPath()
								+ "/servlet/TeacherController");
				request.setAttribute("message", "保存成功！2秒后自动转向教师管理界面。");
				result = "/META-INF/pages/message.jsp";
			}
		}

	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("first") != null) {
			result = "/META-INF/pages/addTeacher.jsp";
		} else {
			TeacherFormBean formBean = FormBeanUtil.fillFormBean(request,
					TeacherFormBean.class);
			if (!formBean.validate()) {
				request.setAttribute("formBean", formBean);
				result = "/META-INF/pages/addTeacher.jsp";
			} else {
				Teacher stu = new Teacher();
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(stu, formBean);
				s.addTeacher(stu);
				response.setHeader("Refresh",
						"2;URL=" + request.getContextPath()
								+ "/servlet/TeacherController");
				request.setAttribute("message", "保存成功！2秒后自动转向教师管理界面。");
				result = "/META-INF/pages/message.jsp";
			}
		}

	}

	private void show(HttpServletRequest request, HttpServletResponse response, List<Teacher> teachers) {
		List<TeacherFormBean> teachersF = new LinkedList<TeacherFormBean>();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Teacher stu = new Teacher();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			for (int i = 0; i < teachers.size(); i++) {
				TeacherFormBean stuF = new TeacherFormBean();
				stu = teachers.get(i);
				BeanUtils.copyProperties(stuF, stu);
				String sDate = df.format(stu.getBirth());
				stuF.setBirth(sDate);
				teachersF.add(stuF);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		request.setAttribute("teachers", teachersF);
		request.getSession().setAttribute("save", teachers);
		result = "/META-INF/pages/teacher.jsp";
	}

}
