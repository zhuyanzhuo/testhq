package com.baizhi.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.util.MybatisUtils;

public class TestUtil {
	@Test
	public void testUtil(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		System.out.println(sqlSession);
		MybatisUtils.close();
	}
}
