package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.CategoryDao;
import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.CategoryService;
import com.baizhi.util.MybatisUtils;

public class CategoryServiceImpl implements CategoryService {

	/**
	 * 查询所有的一级类别和二级类别，返回所有的类别
	 */
	@Override
	public List<Category> findAll() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
		List<Category> list = mapper.findAll();
		MybatisUtils.close();
		return list;
	}

	/**
	 * 按照传过来的类别对象创建一个一级类别
	 */
	@Override
	public void addParentService(Category category) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
			mapper.addOne(category);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 按id删除一个类别
	 */
	@Override
	public void deleteService(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
			mapper.deleteOne(id);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 查找所有一级类别
	 */
	@Override
	public List<Category> findAllFirst() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
		List<Category> list = mapper.findAllParent();
		MybatisUtils.close();
		return list;
	}

	/**
	 * 通过名字查找一个一级类别，返回一个一级类别对象
	 */
	@Override
	public Category findByName(String name) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
		Category category = mapper.findByName(name);
		MybatisUtils.close();
		return category;
	}

	/**
	 * 添加一个二级类别
	 */
	@Override
	public void addSecoundService(Category category) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
			mapper.addSecound(category);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 查找所有的二级类别
	 */
	@Override
	public List<Category> findAllSecound() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
		List<Category> list = mapper.findAllSecound();
		MybatisUtils.close();
		return list;
	}

	/**
	 * 根据传过来的一个一级类别的id查找所有的属于这个一级类别的二级类别
	 * 同时查找出所有的二级类别下的所有图书
	 * @return	返回：一个一级类别的对象
	 */
	@Override
	public Category findFirstAndSecoundAndBook(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
		Category FirstCategory = mapper.findFirstAndSecoundAndBook(id);
		MybatisUtils.close();
		return FirstCategory;
	}

	/**
	 * 根据一个二级类别查找此二级类别下的所有图书
	 * @param id	参数：一个二级类别的id
	 * @return	返回值：此二级类别下的所有图书
	 */
	@Override
	public List<Book> findBookBySecound(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		CategoryDao mapper = sqlSession.getMapper(CategoryDao.class);
		List<Book> list = mapper.findBookBySecound(id);
		MybatisUtils.close();
		return list;
	}

	/**
	 * 动态获取页数
	 * 用于前台点击一级和二级分类时，获取到他们下面的所有图书
	 * 按图书的数量获取这些图书应该分为多少页
	 * @param count
	 * @return
	 */
	@Override
	public Integer total(Integer count) {
		Integer total = null;
		if(count % 3 == 0){
			total = count / 3;
		}else{
			total = count / 3 + 1;
		}
		return total;
	}

}






