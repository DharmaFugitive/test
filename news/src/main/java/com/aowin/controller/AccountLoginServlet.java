package com.aowin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.aowin.model.User;
import com.aowin.service.UserService;

/**
 * Servlet implementation class AccountLoginServlet
 */
@WebServlet("/AccountLogin")
public class AccountLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String account = request.getParameter("account");
		String password = request.getParameter("password");
		System.out.println("到AccountLoginservlet" + account + password);
		User loginUser = new User(account, password);
		UserService userService = new UserService();
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();// 获取writer方法，用于将数据返回给ajax
		
		try {
			User user = userService.loginCheck(loginUser);
			System.out.println("user"+user);
			// 将java对象转换为json对象
			/*
			 * jsonObject.put("user", JSONObject.toJSON(user)); jsonObject.put("message",
			 * "用户登录成功！");
			 */
			String json = JSONObject.toJSONString(user);
			out.print(json);
			out.flush();
			out.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
