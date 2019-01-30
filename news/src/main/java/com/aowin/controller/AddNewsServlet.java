package com.aowin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.model.News;
import com.aowin.model.User;
import com.aowin.service.NewsService;
import com.aowin.service.UserService;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
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
		String typeStr = request.getParameter("type");
		String type =null;
		if(typeStr.equals("0")) {
			type = "管理员";
		}else if(typeStr.equals("1")) {
			type = "娱乐";
		}else if(typeStr.equals("2")) {
			type = "国际";
		}else if(typeStr.equals("3")) {
			type = "体育";
		}else if(typeStr.equals("4")) {
			type = "民生";
		}else {
			type = "未分类";
		}
		int num = 0;
		News news = new News(title, description, content, createtime, author, type);
		System.out.println("servlet"+news);
		NewsService newsDao = new NewsService();
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			num = newsDao.addNews(news);
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
