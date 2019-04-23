package com.baizhi.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory sessionFactory;
	private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();
	static{
		try{
			InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取sqlSession链接对象
	 */
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = t.get();
		if(sqlSession == null){
			sqlSession = sessionFactory.openSession();
			t.set(sqlSession);
		}
		return sqlSession;
	}
	
	/**
	 * 释放资源
	 */
	public static void close(){
		SqlSession sqlSession = t.get();
		if(sqlSession != null){
			sqlSession.close();
			t.remove();
		}
	}
}











