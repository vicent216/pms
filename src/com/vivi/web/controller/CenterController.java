package com.vivi.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vivi.domain.User;
import com.vivi.service.impl.UserServiceImpl;
import com.vivi.util.FormBeanUtil;
import com.vivi.web.formbean.LoginFormBean;

public class CenterController extends HttpServlet {
	private UserServiceImpl s = new UserServiceImpl();
	private String encoding = "UTF-8";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		String operation = request.getParameter("operation");
		if("login".equals(operation)) {
			login(request, response);
		} else if("logout".equals(operation)) {
			logout(request, response);
		}
	
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		String result = "";
		request.getSession().removeAttribute("user");
		response.setHeader("Refresh", "2;URL="+request.getContextPath());
		request.setAttribute("message", "注销成功！2秒后自动转向登录界面。");
		result = "/META-INF/pages/message.jsp";
		try {
			request.getRequestDispatcher(result).forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String result = "";
		LoginFormBean formBean = FormBeanUtil.fillFormBean(request, LoginFormBean.class);
		if(!formBean.validate()) {
			request.setAttribute("formBean", formBean);
			result = "/META-INF/pages/login.jsp";
		} else {
			User user = s.login(formBean.getUsername(), formBean.getPassword());
			if(user == null) {
				formBean.getErrors().put("message", "错误的用户名或密码");
				request.setAttribute("formBean", formBean);
				result = "/META-INF/pages/login.jsp";
			} else {
				request.getSession().setAttribute("user", user);
				response.setHeader("Refresh", "2;URL="+request.getContextPath());
				request.setAttribute("message", "登录成功！2秒后自动转向主页。");
				result = "/META-INF/pages/message.jsp";
			}
		}
		try {
			request.getRequestDispatcher(result).forward(request, response);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
	}

}
