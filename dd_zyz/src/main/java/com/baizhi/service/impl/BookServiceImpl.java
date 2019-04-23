package com.baizhi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.BookDao;
import com.baizhi.entity.Book;
import com.baizhi.service.BookService;
import com.baizhi.util.MybatisUtils;

public class BookServiceImpl implements BookService {

	/**
	 * 查询所有图书
	 * @return	返回：所有的图书集合
	 */
	@Override
	public List<Book> findAll() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao mapper = sqlSession.getMapper(BookDao.class);
		List<Book> list = mapper.findAll();
		MybatisUtils.close();
		return list;
	}

	/**
	 * 按id查询一本图书
	 * @param id	参数：图书的id
	 * @return	返回：目标图书对象
	 */
	@Override
	public Book findOne(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao mapper = sqlSession.getMapper(BookDao.class);
		Book book = mapper.findOne(id);
		MybatisUtils.close();
		return book;
	}

	/**
	 * 根据书名模糊查询
	 * @param name	参数：图书名(输入的字段可能不完整)
	 * @return	返回：查询到的目标图书的集合
	 */
	@Override
	public List<Book> findByName(String name) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao mapper = sqlSession.getMapper(BookDao.class);
		List<Book> list = mapper.findByName(name);
		MybatisUtils.close();
		return list;
	}

	/**
	 * 根据作者名模糊查询
	 * @param author	参数：作者名(输入的字段可能不完整)
	 * @return	返回：查询到的目标图书的集合
	 */
	@Override
	public List<Book> findByAuthor(String author) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao mapper = sqlSession.getMapper(BookDao.class);
		List<Book> list = mapper.findByAuthor(author);
		MybatisUtils.close();
		return list;
	}

	/**
	 * 根据出版社模糊查询
	 * @param press		参数：出版社名(输入的字段可能不完整)
	 * @return		返回：查询到的目标图书的集合
	 */
	@Override
	public List<Book> findByPress(String press) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao mapper = sqlSession.getMapper(BookDao.class);
		List<Book> list = mapper.findByPress(press);
		MybatisUtils.close();
		return list;
	}

	/**
	 * 添加一本图书
	 * @param book	参数：一个图书对象
	 */
	@Override
	public void addOneBook(Book book) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			BookDao mapper = sqlSession.getMapper(BookDao.class);
			mapper.addOneBook(book);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 根据id删除一本图书
	 * @param id	参数：一本图书的id
	 */
	@Override
	public void deleteOneBook(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			BookDao mapper = sqlSession.getMapper(BookDao.class);
			mapper.deleteOneBook(id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 修改一本图书的字段
	 * @param book	参数：一个图书对象
	 */
	@Override
	public void updateOneBook(Book book) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			BookDao mapper = sqlSession.getMapper(BookDao.class);
			mapper.updateOneBook(book);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 查询编辑推荐的两本图书
	 */
	@Override
	public List<Book> selectByRecommend() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao mapper = sqlSession.getMapper(BookDao.class);
		List<Book> findAll = mapper.findAll();
		MybatisUtils.close();
		Integer a = new Random().nextInt(findAll.size());
		Integer b = new Random().nextInt(findAll.size());
		while(true){
			if(a == b){
				b = new Random().nextInt(findAll.size());
			}
			if(a != b){
				break;
			}
		}
		List<Book> list = new ArrayList<Book>();
		list.add(findAll.get(a));
		list.add(findAll.get(b));
		return list;
	}

	/**
	 * 查询热卖的前8本图书
	 */
	@Override
	public List<Book> selectBookBySale() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao mapper = sqlSession.getMapper(BookDao.class);
		List<Book> list = mapper.selectBookBySale();
		MybatisUtils.close();
		return list;
	}

	/**
	 * 查询最新上架的前8本图书
	 */
	@Override
	public List<Book> selectBookByCreateTime() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao mapper = sqlSession.getMapper(BookDao.class);
		List<Book> list = mapper.selectBookByCreateTime();
		MybatisUtils.close();
		return list;
	}

	/**
	 * 查询最新热卖的前10本图书
	 */
	@Override
	public List<Book> selectBookByNewAndCreateTime() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		BookDao mapper = sqlSession.getMapper(BookDao.class);
		List<Book> list = mapper.selectBookByNewAndCreateTime();
		MybatisUtils.close();
		return list;
	}

}









