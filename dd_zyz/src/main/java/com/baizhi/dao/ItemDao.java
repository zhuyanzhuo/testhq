package com.baizhi.dao;

import java.util.List;

import com.baizhi.entity.Item;

public interface ItemDao {
	/**
	 * 查找所有关于当前订单的订单项
	 * @param orderId	参数：当前订单的id
	 * @return	返回值：关于当前订单的所有订单项
	 */
	List<Item> findAllByOrderId(String orderId);
	
	/**
	 * 添加一个订单项
	 * @param item	参数：一个订单项对象
	 */
	void addOneItem(Item item);
	
	/**
	 * 通过订单的id查找有关于此订单的所有订单项，订单项中包含图书的相关信息
	 * @param orderId
	 * @return
	 */
	List<Item> findItemBookByOrderId(String orderId);
}






