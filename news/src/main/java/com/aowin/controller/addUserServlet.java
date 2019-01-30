package com.aowin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.model.User;
import com.aowin.service.UserService;

/**
 * Servlet implementation class addUserServlet
 */
@WebServlet("/addUser")
public class addUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String username = request.getParameter("name");
		String auth = request.getParameter("auth");
		
		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		user.setUsername(username);
		user.setAuth(auth);
		
		System.out.println(user);
		UserService userService = new UserService();
		try {
			int num = userService.addUser(user);
			response.setContentType("text/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(num);
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
