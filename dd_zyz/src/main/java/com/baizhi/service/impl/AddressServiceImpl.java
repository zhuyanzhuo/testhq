package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.AddressDao;
import com.baizhi.entity.Address;
import com.baizhi.service.AddressService;
import com.baizhi.util.MybatisUtils;

public class AddressServiceImpl implements AddressService {

	/**
	 * 查找所有属于当前用户的地址
	 * @param userId	参数：当前用户的id
	 * @return		返回：属于当前用户的所有地址
	 */
	@Override
	public List<Address> findAllByUserId(String userId) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AddressDao mapper = sqlSession.getMapper(AddressDao.class);
		List<Address> list = mapper.findAllByUserId(userId);
		MybatisUtils.close();
		return list;
	}

	/**
	 * 添加一个地址
	 * @param address	一个地址对象
	 */
	@Override
	public void insertOneAddress(Address address) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		try{
			AddressDao mapper = sqlSession.getMapper(AddressDao.class);
			mapper.insertOneAddress(address);
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 根据id查询对应的地址对象
	 * @param id
	 * @return
	 */
	@Override
	public Address findOneById(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AddressDao mapper = sqlSession.getMapper(AddressDao.class);
		Address address = mapper.findOneById(id);
		MybatisUtils.close();
		return address;
	}

}










