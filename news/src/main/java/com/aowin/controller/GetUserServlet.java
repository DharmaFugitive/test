package com.aowin.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class GetUserServlet
 */
@WebServlet("/GetUser")
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("currentPage");
		int currentPage = Integer.parseInt(str);
		System.out.println(str+"跳到getuser");
		
		Page page = new Page();
		page.setCurrentPage(currentPage);
		
			try {
				
				new UserService().getUser(page);// 放入数据
				new UserService().getUserNumber(page);// 放入总数
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String json = JSONArray.toJSONString(page);
			response.setContentType("text/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(json);
			out.flush();
			out.close();
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
