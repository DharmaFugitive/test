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
import com.aowin.model.News;
import com.aowin.service.NewsService;
import com.aowin.service.UserService;

/**
 * Servlet implementation class SelectNewsServlet
 */
@WebServlet("/SelectNews")
public class SelectNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DAO SeleteNewsServlet");
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		String author = request.getParameter("author");
		String type = request.getParameter("type");
		String logic = request.getParameter("logic");
		UserService userService = new UserService();
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<News> selNews = null;
		
		String username = "%"+author+"%";
		try {
			int[] idarr = userService.getIdByUsername(username);
			int idint = idarr[0] ;

		News news = new News();
		if(id != "") {
			news.setId("%"+id+"%");
		}
		if(title != "") {
			news.setTitle("%"+title+"%");
		}
		if(description != "") {
			news.setDescription("%"+description+"%");
		}
		if(content != "") {
			news.setContent("%"+content+"%");
		}
		if(author != "") {
			
			news.setAuthor(idint+"");
		}
		if(type != "") {
			news.setType("%"+type+"%");
		}
		System.out.println("servlet"+news);
		

		NewsService newsService = new NewsService();
		if("and".equals(logic)) {
			selNews = newsService.getNewsByAnd(news);
			System.out.println("and");
			System.out.println(selNews);
		}else {
			selNews = newsService.getNewsByOr(news);
			System.out.println("or");
			System.out.println(selNews);
		}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			String json = JSONArray.toJSONString(selNews);
			out.print(json);
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
