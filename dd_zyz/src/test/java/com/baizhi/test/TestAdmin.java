package com.baizhi.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.util.MybatisUtils;

public class TestAdmin {
	@Test
	public void testAdmin(){
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AdminDao mapper = sqlSession.getMapper(AdminDao.class);
		Admin admin = mapper.login("admin1");
		System.out.println(admin);
		MybatisUtils.close();
	}
}
