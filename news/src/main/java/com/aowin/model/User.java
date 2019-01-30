package com.aowin.model;

import java.util.List;

public class User {
	private String id;
	private String account;
	private String password;
	private String username;
	private String auth;
	
	
	private List<News> newsList;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}


	public User(String username) {
		super();
		this.username = username;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}



	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", password=" + password + ", username=" + username
				+ ", auth=" + auth + ", newsList=" + newsList + "]";
	}


}
