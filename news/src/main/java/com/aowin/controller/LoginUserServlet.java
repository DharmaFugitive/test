package com.aowin.controller;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.aowin.model.User;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/LoginUser")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String username= (String)request.getSession().getAttribute("userName");
		String userAuth= (String)request.getSession().getAttribute("userAuth");
		List userList = new List();
		userList.add(username);
		userList.add(userAuth);
		String json = JSONArray.toJSONString(userList);
		out.print(userList);
		out.flush();
		out.close();
	}

}
