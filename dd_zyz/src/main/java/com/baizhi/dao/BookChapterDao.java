package com.baizhi.dao;


import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.BookChapter;

public interface BookChapterDao {
	/**
	 * 为书签表添加书签，记录的是当前用户所读的当前图书的电子版的章节数
	 * @param bookId
	 * @param userId
	 */
	void save(BookChapter bookChapter);
	
	/**
	 * 按照用户id和此用户名下的某本书的id查找这本书的书签
	 * @param bookId
	 * @param userId
	 * @return
	 */
	BookChapter findByBookAndUser(@Param("bookId")String bookId,@Param("userId")String userId);

	/**
	 * 更改当前用户当前图书的书签
	 * @param bookId
	 * @param userId
	 */
	void updateChapter(BookChapter bookChapter);
}










