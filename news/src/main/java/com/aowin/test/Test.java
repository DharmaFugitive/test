package com.aowin.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.aowin.dao.IUserDao;
import com.aowin.model.Page;
import com.aowin.model.User;
import com.aowin.util.DBUtil;

public class Test {
	public static void main(String[] args) throws Exception {
		SqlSession session = DBUtil.getSession();
		IUserDao userDao = session.getMapper(IUserDao.class);
		
		Page page = new Page();
		page.setCurrentPage(1);
		System.out.println(page.getBegin()+""+page.getCurrentPage()+""+page.getPageSize());
		List<User> userList = userDao.getUserPage(page);
	
		System.out.println(userList);
		
		session.commit();
		session.close();
	}
}

