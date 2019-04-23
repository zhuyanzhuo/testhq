package com.baizhi.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baizhi.entity.Book;
import com.baizhi.entity.User;

public interface UserDao {
	/**
	 * 前台用户登陆，将接收前台输入的email地址，用此地址去数据库查找对应的对象
	 * 若不存在，返回空值并提示错误信息，若存在，则返回用户
	 * @param email		参数：表示接受的email地址
	 * @return		返回值：返回一个用户对象
	 */
	User login(String email);
	
	/**
	 * 接收前台传过来的数据封装成一个全新的用户对象，将此用户对象添加到数据库中
	 * @param user		参数：一个用户对象
	 */
	void register(User user);
	
	/**
	 * 根据id查找一名用户
	 * @param id
	 * @return
	 */
	User findOne(String id);
	
	/**
	 * 根据email查找一名用户
	 * @param email
	 * @return
	 */
	User findOneByEmail(String email);
	
	/**
	 * 修改用户的激活码
	 * @param user
	 */
	void updateKey(User user);
	
	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> showAll();
	
	/**
	 * 按id修改一名用户的状态
	 * @param id
	 */
	void updateStatus(@Param("id")String id,@Param("status")String status);
	
	/**
	 * 通过登陆用户的id查找其名下的所有图书
	 * @return
	 */
	User findAllBookByUser(String userId);
}




