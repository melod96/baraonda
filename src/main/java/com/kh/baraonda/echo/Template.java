package com.kh.baraonda.echo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	public static SqlSession getSqlSession(){

		SqlSession session = null;
		
		try {
			InputStream stream = Resources.getResourceAsStream("mybatis-config2.xml");	
			session = new SqlSessionFactoryBuilder().build(stream).openSession(false);
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return session;
	}
	
}
