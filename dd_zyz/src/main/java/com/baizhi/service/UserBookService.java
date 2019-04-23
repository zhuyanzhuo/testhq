package com.baizhi.service;

public interface UserBookService {

	/**
	 * 将用户id和图书id存入用户——图书表
	 * @param bookId
	 * @param userId
	 */
	void save(String bookId,String userId);
}
