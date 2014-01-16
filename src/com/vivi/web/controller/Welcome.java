package com.vivi.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vivi.domain.User;

public class Welcome extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = "";
		User user = (User) request.getSession().getAttribute("user");
		if(user == null) {
			result = "/META-INF/pages/login.jsp";
		} else {
			result = "/META-INF/pages/main.jsp";
		}
		request.getRequestDispatcher(result).forward(request, response);

	}

}
