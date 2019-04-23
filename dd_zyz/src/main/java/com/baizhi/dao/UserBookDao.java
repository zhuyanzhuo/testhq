package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

public interface UserBookDao {
	/**
	 * 将用户id和图书id存入用户——图书表
	 * @param bookId
	 * @param userId
	 */
	void save(@Param("bookId")String bookId,@Param("userId")String userId);
}
