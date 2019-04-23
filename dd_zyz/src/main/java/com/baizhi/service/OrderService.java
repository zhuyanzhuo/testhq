package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;
import com.baizhi.entity.Order;

public interface OrderService {
	/**
	 * 添加一个订单
	 * @param order
	 */
	void addOneOrder(Address address);
	
	/**
	 * 查找所有的订单，包括此订单所去向的地址
	 * @return
	 */
	List<Order> findAll();
	
	/**
	 * 按id查找一个订单
	 * @param id	订单id
	 * @return		查找到的订单
	 */
	Order findOneById(String id);
}
