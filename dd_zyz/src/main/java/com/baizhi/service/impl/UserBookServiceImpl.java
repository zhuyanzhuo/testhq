package com.baizhi.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.UserBookDao;
import com.baizhi.service.UserBookService;
import com.baizhi.util.MybatisUtils;

public class UserBookServiceImpl implements UserBookService {

	/**
	 * 将用户id和图书id存入用户——图书表
	 * @param bookId
	 * @param userId
	 */
	@Override
	public void save(String bookId, String userId) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			UserBookDao mapper = sqlSession.getMapper(UserBookDao.class);
			mapper.save(bookId, userId);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

}
