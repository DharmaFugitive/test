package com.aowin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.aowin.model.Page;
import com.aowin.model.User;
import com.aowin.service.UserService;

/**
 * Servlet implementation class HomePageInitNewsServlet
 */
@WebServlet("/HomeInitNews")
public class HomePageInitNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("跳到servlet"+"HomeInitNews");
		String str = request.getParameter("currentPage");
		int currentPage = Integer.parseInt(str);
		
		Page page = new Page();
		page.setCurrentPage(currentPage);
		try {
			new UserService().getUserPage(page);
			System.out.println(page.getData());
			String json = JSONArray.toJSONString(page.getData());
			response.setContentType("text/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
