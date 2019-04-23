package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface CategoryDao {
	/**
	 * 查询所有的一级和二级类别
	 * @return	返回：所有的类别
	 */
	List<Category> findAll();
	
	/**
	 * 查找所有的一级类别
	 * @return	返回：所有一级类别
	 */
	List<Category> findAllParent();
	
	/**
	 * 根据传过来的一个一级类别的id查找所有的属于这个一级类别的二级类别
	 * 同时查找出所有的二级类别下的所有图书
	 * @return	返回：一个一级类别的对象
	 */
	Category findFirstAndSecoundAndBook(String id);
	
	/**
	 * 根据一个二级类别查找此二级类别下的所有图书
	 * @param id	参数：一个二级类别的id
	 * @return	返回值：此二级类别下的所有图书
	 */
	List<Book> findBookBySecound(String id);
	
	/**
	 * 通过用户添加二级类别时选择的一级类别名查找一个一级类别
	 * @param name	参数：一级类别的名字
	 * @return	返回：一级类别对象
	 */
	Category findByName(String name);
	
	/**
	 * 添加一个一级类别
	 * @param category	参数是一个一级类别的对象
	 */
	void addOne(Category category);
	
	/**
	 * 添加一个二级类别
	 * @param category	参数：一个二级类别对象
	 */
	void addSecound(Category category);
	
	/**
	 * 删除一个类别
	 * @param id	参数是一个类别的id
	 */
	void deleteOne(String id);
	
	/**
	 * 查找所有的二级类别
	 * @return	返回：所有的二级类别
	 */
	List<Category> findAllSecound();
}




