package com.aowin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.aowin.model.User;

public class AdmitFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		/*
         * 1. 得到session
         * 2. 判断session域中是否存在admin(0)，如果存在，放行
         * 3. 判断session域中是否存在username，如果存在，放行，否则打回到index.html，并告诉它不要瞎留达
         */
		HttpServletRequest req = (HttpServletRequest) request;
		String userAuth = (String)req.getSession().getAttribute("userAuth");
		if(userAuth.equals("0")) {
			chain.doFilter(request, response);
		}else {
			response.getWriter().println("<script>alert(\"你不是管理员,不能执行此操作\");</script>");
	          req.getRequestDispatcher("/news/index.html").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
