package com.aowin.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.aowin.dao.IUserDao;
import com.aowin.model.Page;
import com.aowin.model.User;
import com.aowin.util.DBUtil;

public class UserService {
	// 主页显示新闻信息
	public void getUserPage(Page page) throws Exception{
		SqlSession session = DBUtil.getSession();
		IUserDao userDao = session.getMapper(IUserDao.class);

		List<User> data = userDao.getUserPage(page);
		page.setData(data);
	};
	
	// 账户登陆检查
	public User loginCheck(User user) throws Exception{
		SqlSession session = DBUtil.getSession();
		IUserDao userDao = session.getMapper(IUserDao.class);
		return userDao.loginCheck(user);
	};
	
	// 得到分页所需用户信息
	public void getUser(Page page) throws Exception{
		SqlSession session = DBUtil.getSession();
		IUserDao userDao = session.getMapper(IUserDao.class);
		List<User> data = userDao.getUser(page);
		page.setData(data);
	}
	
	// 得到所有用户的数量
	public void getUserNumber(Page page) throws Exception{
		SqlSession session = DBUtil.getSession();
		IUserDao userDao = session.getMapper(IUserDao.class);
		int total = userDao.getUserNumber();
		int totalPage;
		if(total%page.getPageSize() == 0) {
			totalPage =total/page.getPageSize();
		}else {
			totalPage =total/page.getPageSize()+1; 
		}
		page.setTotalPage(totalPage);
	}
	
	// 用户账号检查是否存在
	public boolean userAccountCheck(String account) throws Exception{
		boolean flag = true;
		SqlSession session = DBUtil.getSession();
		IUserDao userDao = session.getMapper(IUserDao.class);
		int num = userDao.userAccountCheck(account);
		if(num==0) {
			flag =  false;
		}
		System.out.println("service"+flag);
		return flag;
	}
	
	// 新增用户
	public int addUser(User user) throws Exception{
		SqlSession session = DBUtil.getSession();
		IUserDao userDao = session.getMapper(IUserDao.class);
		
		int num = userDao.addUser(user);
		if(num==1) {
			session.commit();
		}
		
		return num;
	}
	
	// 删除用户
	public void deleteUser(int id) throws Exception{
		SqlSession session = DBUtil.getSession();
		IUserDao userDao = session.getMapper(IUserDao.class);
		
		userDao.deleteUser(id);	
		session.commit();
		session.close();
	}
	
	// 根据id获取用户信息
	public User getUserById(int id) throws Exception{
		SqlSession session = DBUtil.getSession();
		IUserDao userDao = session.getMapper(IUserDao.class);
		
		User user = userDao.getUserById(id);
		return user;
	};
	
	// 根据模糊名字,获取id
	public int[] getIdByUsername(String username) throws Exception{
		SqlSession session = DBUtil.getSession();
		IUserDao userDao = session.getMapper(IUserDao.class);
		
		int[] id = userDao.getIdByUsername(username);
		System.out.println(id);
		return id;
	}
}
