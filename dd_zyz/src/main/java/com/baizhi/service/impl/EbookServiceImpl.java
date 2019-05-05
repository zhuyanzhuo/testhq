package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.EbookDao;
import com.baizhi.entity.Ebook;
import com.baizhi.service.EbookService;
import com.baizhi.util.MybatisUtils;

public class EbookServiceImpl implements EbookService {

	/**
	 * 查找一本书的某一章节的所有段落，按从第一段到最后一段的顺序展示
	 * @return
	 */
	@Override
	public List<Ebook> findAll(String bookId, Integer chapter) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		EbookDao mapper = sqlSession.getMapper(EbookDao.class);
		List<Ebook> list = mapper.findAll(bookId, chapter);
		MybatisUtils.close();
		return list;
	}

	/**
	 * 添加电子书的一个段落
	 * @param ebook
	 */
	@Override
	public void save(Ebook ebook) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			EbookDao mapper = sqlSession.getMapper(EbookDao.class);
			mapper.save(ebook);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 按照一本图书的id删除其对应的所有电子书段落
	 * @param bookId
	 */
	@Override
	public void delete(String bookId) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			EbookDao mapper = sqlSession.getMapper(EbookDao.class);
			mapper.delete(bookId);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 在进行添加一条电子书段落之前先进行查询
	 * 判断是否已经有一条数据存在
	 * @param bookId
	 * @param chapter
	 * @param grade
	 * @return
	 */
	@Override
	public Ebook findOne(String bookId, Integer chapter, Integer grade) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		EbookDao mapper = sqlSession.getMapper(EbookDao.class);
		Ebook ebook = mapper.findOne(bookId, chapter, grade);
		MybatisUtils.close();
		return ebook;
	}

	/**
	 * 删除一条电子书段落的数据
	 * @param id
	 */
	@Override
	public void deleteOne(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			EbookDao mapper = sqlSession.getMapper(EbookDao.class);
			mapper.delete(id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 查找此图书的最大章节数
	 * @return
	 */
	@Override
	public Integer findMaxChapter(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		EbookDao mapper = sqlSession.getMapper(EbookDao.class);
		Integer maxChapter = mapper.findMaxChapter(id);
		MybatisUtils.close();
		return maxChapter;
	}

	/**
	 * 通过id查找到一个段落，将段落的点赞数+1
	 * @param id
	 */
	@Override
	public void addLikeNum(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			EbookDao mapper = sqlSession.getMapper(EbookDao.class);
			mapper.addLikeNum(id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 通过图书的id查找到当前图书的电子版被点赞次数最多的一段
	 * @param book_id
	 * @return
	 */
	@Override
	public Ebook findByLikeNum(String book_id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		EbookDao mapper = sqlSession.getMapper(EbookDao.class);
		Ebook ebook = mapper.findByLikeNum(book_id);
		MybatisUtils.close();
		return ebook;
	}

	/**
	 * 通过图书id查找此图书的电子版一共有多少章节
	 * @param book_id
	 * @return
	 */
	@Override
	public List<Integer> findAllChapter(String book_id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		EbookDao mapper = sqlSession.getMapper(EbookDao.class);
		List<Integer> list = mapper.findAllChapter(book_id);
		MybatisUtils.close();
		return list;
	}


}
