package com.aowin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.aowin.model.News;
import com.aowin.service.NewsService;

/**
 * Servlet implementation class GetNewsByIdServlet
 */
@WebServlet("/DelNewsByIdServlet")
public class DelNewsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		System.out.println("到刪除servlet"+idStr);
		
		int id = Integer.parseInt(idStr);
		int num =-1;
		PrintWriter out = response.getWriter();
		try {
			num= new NewsService().delNewsById(id);
			response.setContentType("text/json;charset=utf-8");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			num = 0;
		}finally {
			out.println(num);
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
