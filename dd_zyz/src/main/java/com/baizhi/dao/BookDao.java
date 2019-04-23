package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;

public interface BookDao {
	/**
	 * 查询所有图书
	 * @return	返回：所有的图书集合
	 */
	List<Book> findAll();
	/**
	 * 按id查询一本图书
	 * @param id	参数：图书的id
	 * @return	返回：目标图书对象
	 */
	Book findOne(String id);
	/**
	 * 根据书名模糊查询
	 * @param name	参数：图书名(输入的字段可能不完整)
	 * @return	返回：查询到的目标图书的集合
	 */
	List<Book> findByName(String name);
	/**
	 * 根据作者名模糊查询
	 * @param author	参数：作者名(输入的字段可能不完整)
	 * @return	返回：查询到的目标图书的集合
	 */
	List<Book> findByAuthor(String author);
	/**
	 * 根据出版社模糊查询
	 * @param press		参数：出版社名(输入的字段可能不完整)
	 * @return		返回：查询到的目标图书的集合
	 */
	List<Book> findByPress(String press);
	/**
	 * 查询销量前8的图书
	 * @return	返回销量前8的图书集合
	 */
	List<Book> selectBookBySale();
	/**
	 * 查询最新上架的8本图书
	 * @return	返回最新的8本图书的集合
	 */
	List<Book> selectBookByCreateTime();
	/**
	 * 查询最新热卖的10本图书
	 * @return	返回最新热卖的10本图书的集合
	 */
	List<Book> selectBookByNewAndCreateTime();
	/**
	 * 添加一本图书
	 * @param book	参数：一个图书对象
	 */
	void addOneBook(Book book);
	/**
	 * 根据id删除一本图书
	 * @param id	参数：一本图书的id
	 */
	void deleteOneBook(String id);
	/**
	 * 修改一本图书的字段
	 * @param book	参数：一个图书对象
	 */
	void updateOneBook(Book book);
	
	/**
	 * 修改图书的销量和库存
	 * @param id
	 * @param count
	 */
	void updateBookCount(@Param("id")String id,@Param("count")Integer count);

	/**
	 * 电子书的购买——只修改销量
	 * @param id
	 * @param count
	 */
	void updateSale(@Param("id")String id,@Param("count")Integer count);
}










