package com.aowin.util;



import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	private static SqlSessionFactory factory;
	
	static {
		try {
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			Reader reader = Resources.getResourceAsReader("config.xml");
			factory = builder.build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSession getSession() {
		return factory.openSession();
	}

	
	
}
