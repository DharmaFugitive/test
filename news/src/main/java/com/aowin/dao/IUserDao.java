package com.aowin.dao;

import java.util.List;

import com.aowin.model.Page;
import com.aowin.model.User;


public interface IUserDao {
	// 登陆检查
	public User loginCheck(User user) throws Exception;

	// 管理主页显示
	public List<User> getUserPage(Page page) throws Exception;
	
	// 得到分页中用户信息
	public List<User> getUser(Page page) throws Exception;
	// 得到所有用户的条数
	public int getUserNumber() throws Exception;
	
	// 用户账号检查是否存在
	public int userAccountCheck(String account) throws Exception;
	
	// 新增用户
	public int addUser(User user) throws Exception;
	
	// 删除用户
	public void deleteUser(int id) throws Exception;
	
	// 根据id获取用户信息
	public User getUserById(int id) throws Exception;
	
	// 根据模糊名字,获取id
	public int[] getIdByUsername(String username) throws Exception;
	
}
