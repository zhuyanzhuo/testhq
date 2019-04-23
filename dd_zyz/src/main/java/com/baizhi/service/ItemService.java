package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Item;

public interface ItemService {
	/**
	 * 通过订单的id查找有关于此订单的所有订单项，订单项中包含图书的相关信息
	 * @param orderId
	 * @return
	 */
	List<Item> findItemBookByOrderId(String orderId);
}
