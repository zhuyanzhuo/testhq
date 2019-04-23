package com.baizhi.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.util.MybatisUtils;

public class AdminServiceImpl implements AdminService {

	/**
	 * 进行管理员的登陆验证，首先将根据输入的用户名去查找用户是否存在，
	 * 若存在，则将获得的用户信息对象返回，
	 * 若不存在，返回一个空值
	 */
	@Override
	public Admin loginService(String username) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AdminDao mapper = sqlSession.getMapper(AdminDao.class);
		Admin admin = mapper.login(username);
		MybatisUtils.close();
		return admin;
	}

}
