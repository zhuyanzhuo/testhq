package com.baizhi.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.BookChapterDao;
import com.baizhi.entity.BookChapter;
import com.baizhi.service.BookChapterService;
import com.baizhi.util.MybatisUtils;

public class BookChapterServiceImpl implements BookChapterService {

	/**
	 * 为书签表添加书签，记录的是当前用户所读的当前图书的电子版的章节数,初始值为1
	 */
	@Override
	public void save(BookChapter bookChapter) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			BookChapterDao mapper = sqlSession.getMapper(BookChapterDao.class);
			mapper.save(bookChapter);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 按照用户id和此用户名下的某本书的id查找这本书的书签
	 * @param bookId
	 * @param userId
	 * @return
	 */
	@Override
	public BookChapter findByBookAndUser(String bookId, String userId) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookChapterDao mapper = sqlSession.getMapper(BookChapterDao.class);
		BookChapter bookChapter = mapper.findByBookAndUser(bookId, userId);
		MybatisUtils.close();
		return bookChapter;
	}

	/**
	 * 更改当前用户当前图书的书签
	 */
	@Override
	public void updateChapter(BookChapter bookChapter) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			BookChapterDao mapper = sqlSession.getMapper(BookChapterDao.class);
			mapper.updateChapter(bookChapter);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

}









