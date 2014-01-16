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

import com.vivi.domain.Postgraduate;
import com.vivi.domain.Teacher;
import com.vivi.service.PostgraduateService;
import com.vivi.service.TeacherService;
import com.vivi.service.impl.PostgraduateServiceImpl;
import com.vivi.service.impl.TeacherServiceImpl;
import com.vivi.util.FormBeanUtil;
import com.vivi.web.formbean.PostgraduateFormBean;

public class PostgraduateController extends HttpServlet {
	PostgraduateService s = new PostgraduateServiceImpl();
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
				List<Postgraduate> postgraduates = s.showPostgraduates();
				show(request, response, postgraduates);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		request.getRequestDispatcher(result).forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		List<Postgraduate> postgraduates = (List<Postgraduate>) request.getSession().getAttribute("save");
		if(postgraduates != null) {
			s.savePostgraduates(postgraduates);
		}
		postgraduates = s.showPostgraduates();
		show(request, response, postgraduates);
//		request.getSession().removeAttribute("save");
	}

	private void sort(HttpServletRequest request, HttpServletResponse response) {
		String attr = request.getParameter("attr");
		List<Postgraduate> postgraduates = s.sortPostgraduates(attr, 0);
		show(request, response, postgraduates);
	}

	private void find(HttpServletRequest request, HttpServletResponse response) {
		String attr = request.getParameter("attr");
		String str = request.getParameter("str");
		List<Postgraduate> postgraduates = new ArrayList<Postgraduate>();
		if (str == null || "".equals(str)) {
			postgraduates = s.showPostgraduates();
			show(request, response, postgraduates);
		} else {
			postgraduates = s.findPostgraduate(attr, str);
			show(request, response, postgraduates);
		}

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		s.deletePostgraduate(num);
		response.setHeader("Refresh", "2;URL=" + request.getContextPath()
				+ "/servlet/PostgraduateController");
		request.setAttribute("message", "删除成功！2秒后自动转向研究生管理界面。");
		result = "/META-INF/pages/message.jsp";
	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String num = request.getParameter("num");
		if (request.getParameter("first") != null) {
			Postgraduate stu = s.findPostgraduate("num", num).get(0);
			PostgraduateFormBean stuF = new PostgraduateFormBean();
			BeanUtils.copyProperties(stuF, stu);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			String sDate = df.format(stu.getBirth());
			stuF.setBirth(sDate);
			
			Teacher t = stu.getTeacher();
			if(t != null) {
				stuF.setTeacherNum(stu.getTeacher().getNum());
			}
			request.setAttribute("formBean", stuF);

			result = "/META-INF/pages/updatePostgraduate.jsp";
		} else {
			request.removeAttribute("formBean");
			PostgraduateFormBean formBean = FormBeanUtil.fillFormBean(request,
					PostgraduateFormBean.class);
			if (!formBean.validate()) {
				request.setAttribute("formBean", formBean);
				result = "/META-INF/pages/updatePostgraduate.jsp";
			} else {
				Postgraduate stu = new Postgraduate();
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(stu, formBean);
				
				TeacherService ts = new TeacherServiceImpl();
				List<Teacher> t = ts.findTeacher("num", formBean.getTeacherNum());
				if((t != null) && (!t.isEmpty())) {
					stu.setTeacher(t.get(0));
				}
				
				s.updatePostgraduate(stu, num);
				response.setHeader("Refresh",
						"2;URL=" + request.getContextPath()
								+ "/servlet/PostgraduateController");
				request.setAttribute("message", "保存成功！2秒后自动转向研究生管理界面。");
				result = "/META-INF/pages/message.jsp";
			}
		}

	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (request.getParameter("first") != null) {
			result = "/META-INF/pages/addPostgraduate.jsp";
		} else {
			PostgraduateFormBean formBean = FormBeanUtil.fillFormBean(request,
					PostgraduateFormBean.class);
			if (!formBean.validate()) {
				request.setAttribute("formBean", formBean);
				result = "/META-INF/pages/addPostgraduate.jsp";
			} else {
				Postgraduate stu = new Postgraduate();
				ConvertUtils.register(new DateLocaleConverter(), Date.class);
				BeanUtils.copyProperties(stu, formBean);
				
				TeacherService ts = new TeacherServiceImpl();
				List<Teacher> t = ts.findTeacher("num", formBean.getTeacherNum());
				if((t != null) && (!t.isEmpty())) {
					stu.setTeacher(t.get(0));
				}
				
				s.addPostgraduate(stu);
				response.setHeader("Refresh",
						"2;URL=" + request.getContextPath()
								+ "/servlet/PostgraduateController");
				request.setAttribute("message", "保存成功！2秒后自动转向研究生管理界面。");
				result = "/META-INF/pages/message.jsp";
			}
		}

	}

	private void show(HttpServletRequest request, HttpServletResponse response, List<Postgraduate> postgraduates) {
		List<PostgraduateFormBean> postgraduatesF = new LinkedList<PostgraduateFormBean>();
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Postgraduate stu = new Postgraduate();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			for (int i = 0; i < postgraduates.size(); i++) {
				PostgraduateFormBean stuF = new PostgraduateFormBean();
				stu = postgraduates.get(i);
				BeanUtils.copyProperties(stuF, stu);
				String sDate = df.format(stu.getBirth());
				stuF.setBirth(sDate);
				
				Teacher t = stu.getTeacher();
				if(t != null) {
					stuF.setTeacher(t.getName());
				} 
				postgraduatesF.add(stuF);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		request.setAttribute("postgraduates", postgraduatesF);
		request.getSession().setAttribute("save", postgraduates);
		result = "/META-INF/pages/postgraduate.jsp";
	}

}
