package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;

public interface CategoryService {
	List<Category> findAll();
	List<Category> findAllFirst();
	Category findByName(String name);
	void addParentService(Category category);
	void addSecoundService(Category category);
	void deleteService(String id);
	List<Category> findAllSecound();
	Category findFirstAndSecoundAndBook(String id);
	List<Book> findBookBySecound(String id);
	
	/**
	 * 动态获取页数
	 * 用于前台点击一级和二级分类时，获取到他们下面的所有图书
	 * 按图书的数量获取这些图书应该分为多少页
	 * @param count
	 * @return
	 */
	Integer total(Integer count);
}









