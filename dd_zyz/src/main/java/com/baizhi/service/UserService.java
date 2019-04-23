package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.User;

public interface UserService {
	/**
	 * 前台用户登陆，将接收前台输入的email地址，用此地址去数据库查找对应的对象
	 * 若不存在，返回空值并提示错误信息，若存在，则返回用户
	 * @param email		参数：表示接受的email地址
	 * @return		返回值：返回一个用户对象
	 */
	User loginService(String email);
	/**
	 * 接收前台传过来的数据封装成一个全新的用户对象，将此用户对象添加到数据库中
	 * @param user		参数：一个用户对象
	 */
	void registerService(User user);
	/**
	 * 根据id查询一名用户
	 * @param id	参数：一名用户的id
	 * @return		返回值：一个用户对象
	 */
	User findOneService(String id);
	/**
	 * 根据email查找一名用户
	 * @param email
	 * @return
	 */
	User findOneByEmailService(String email);
	/**
	 * 修改一名用户的激活码
	 * @param user
	 */
	void updateKeyService(User user);
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> showAll();
	
	/**
	 * 按id修改一名用户的状态
	 * @param id
	 */
	void updateStatus(String id,String status);
	
	/**
	 * 通过登陆用户的id查找其名下的所有图书
	 * @return
	 */
	User findAllBookByUser(String userId);
}








