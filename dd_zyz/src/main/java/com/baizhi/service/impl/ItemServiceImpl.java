package com.baizhi.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.baizhi.dao.ItemDao;
import com.baizhi.entity.Item;
import com.baizhi.service.ItemService;
import com.baizhi.util.MybatisUtils;

public class ItemServiceImpl implements ItemService {

	/**
	 * 通过订单的id查找有关于此订单的所有订单项，订单项中包含图书的相关信息
	 * @param orderId
	 * @return
	 */
	@Override
	public List<Item> findItemBookByOrderId(String orderId) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		ItemDao mapper = sqlSession.getMapper(ItemDao.class);
		List<Item> list = mapper.findItemBookByOrderId(orderId);
		MybatisUtils.close();
		return list;
	}

}












