package com.aowin.controller;

import com.aowin.service.UserService;

public class Test {

	public static void main(String[] args) throws Exception {
		String username="%1%";
		// TODO Auto-generated method stub
		int[] se = new UserService().getIdByUsername(username);
		System.out.println(se.length);
	}

}
