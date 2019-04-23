package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MybatisUtils;

public class UserServiceImpl implements UserService {

	/**
	 * 前台用户登陆，将接收前台输入的email地址，用此地址去数据库查找对应的对象
	 * 若不存在，返回空值并提示错误信息，若存在，则返回用户
	 */
	@Override
	public User loginService(String email) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		User user = mapper.login(email);
		MybatisUtils.close();
		return user;
	}

	/**
	 * 接收前台传过来的数据封装成一个全新的用户对象，将此用户对象添加到数据库中
	 */
	@Override
	public void registerService(User user) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			mapper.register(user);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally {
			MybatisUtils.close();
		}
	}

	/**
	 * 根据id查询一名用户
	 */
	@Override
	public User findOneService(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		User user = mapper.findOne(id);
		MybatisUtils.close();
		return user;
	}

	/**
	 * 根据email查找一名用户
	 */
	@Override
	public User findOneByEmailService(String email) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		User user = mapper.findOneByEmail(email);
		MybatisUtils.close();
		return user;
	}

	/**
	 * 修改一名用户的激活码
	 */
	@Override
	public void updateKeyService(User user) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			mapper.updateKey(user);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 查询所有用户
	 * @return
	 */
	@Override
	public List<User> showAll() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		List<User> list = mapper.showAll();
		MybatisUtils.close();
		return list;
	}

	/**
	 * 按id修改一名用户的状态
	 */
	@Override
	public void updateStatus(String id, String status) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			UserDao mapper = sqlSession.getMapper(UserDao.class);
			mapper.updateStatus(id, status);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 通过登陆用户的id查找其名下的所有图书
	 * @return
	 */
	@Override
	public User findAllBookByUser(String userId) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		UserDao mapper = sqlSession.getMapper(UserDao.class);
		User user = mapper.findAllBookByUser(userId);
		MybatisUtils.close();
		return user;
	}

}








