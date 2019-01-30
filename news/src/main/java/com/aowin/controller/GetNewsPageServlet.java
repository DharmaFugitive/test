package com.aowin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.aowin.model.Page;
import com.aowin.service.NewsService;

/**
 * Servlet implementation class GetNewsPageServlet
 */
@WebServlet("/GetNewsPageServlet")
public class GetNewsPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("currentPage");
		System.out.println(str);
		int currentPage = Integer.parseInt(str);
		
		Page page = new Page();
		page.setCurrentPage(currentPage);
		
		try {
			new NewsService().getNewsNumber(page);
			new NewsService().getNewsPage(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(page);
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
