package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Ebook;

public interface EbookService {

	/**
	 * 查找一本书的某一章节的所有段落，按从第一段到最后一段的顺序展示
	 * @return
	 */
	List<Ebook> findAll(String bookId,Integer chapter);

	/**
	 * 添加电子书的一个段落
	 * @param ebook
	 */
	void save(Ebook ebook);
	
	/**
	 * 按照一本图书的id删除其对应的所有电子书段落
	 * @param bookId
	 */
	void delete(String bookId);
	
	/**
	 * 删除一条电子书段落的数据
	 * @param id
	 */
	void deleteOne(String id);
	
	/**
	 * 在进行添加一条电子书段落之前先进行查询
	 * 判断是否已经有一条数据存在
	 * @param bookId
	 * @param chapter
	 * @param grade
	 * @return
	 */
	Ebook findOne(String bookId,Integer chapter,Integer grade);
	
	/**
	 * 查找此图书的最大章节数
	 * @return
	 */
	Integer findMaxChapter(String id);
	
	/**
	 * 通过id查找到一个段落，将段落的点赞数+1
	 * @param id
	 */
	void addLikeNum(String id);
	
	/**
	 * 通过图书的id查找到当前图书的电子版被点赞次数最多的前5段进行降序展示
	 * @param bookId
	 * @return
	 */
	List<Ebook> findByLikeNum(String book_id);

}
