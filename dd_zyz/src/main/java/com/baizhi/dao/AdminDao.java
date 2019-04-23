package com.baizhi.dao;

import com.baizhi.entity.Admin;

public interface AdminDao {
	/**
	 * 管理员登陆验证，将会接收一个用户名，使用接受的用户名去数据库中查找对应的对象
	 * 若不存在，则返回空值并提示错误信息
	 * 若存在，则返回用户
	 * @param username	表示接收的用户名
	 * @return	表示返回一个管理员用户(可能为空)
	 */
	Admin login(String username);
}
