package com.aowin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.model.News;
import com.aowin.service.NewsService;

/**
 * Servlet implementation class UpdateNewsServlet
 */
@WebServlet("/UpdateNewsServlet")
public class UpdateNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		String createtime = request.getParameter("createtime");
		String author = request.getParameter("author");
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		int intId = Integer.parseInt(id);
		System.out.println(intId);
		
		News news = new News(intId, title, description, content, createtime, author, type);
		System.out.println("servlet"+news);
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		NewsService newsDao = new NewsService();
		int num = 0;
		try {
			num = newsDao.updateBySet(news);
			out.print(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print(num);
		}finally {
			out.flush();
			out.close();
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
