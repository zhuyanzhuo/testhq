package com.baizhi.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import com.baizhi.dao.*;
import com.baizhi.entity.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.baizhi.service.OrderService;
import com.baizhi.util.MybatisUtils;

public class OrderServiceImpl implements OrderService {

	/**
	 * 添加一个订单
	 * 同时还要做的操作：
	 * 添加新地址或者修改原有地址
	 * 添加订单项
	 * 修改图书的销量和库存
	 * 如果有电子书，为用户添加电子书
	 * 移除购物车
	 */
	@Override
	public void addOneOrder(Address address) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		Double total = (Double) session.getAttribute("total");
		HashMap<String,HashMap<Book,Integer>> cart = (HashMap<String,HashMap<Book,Integer>>)session.getAttribute("cart");
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		AddressDao addressDao = sqlSession.getMapper(AddressDao.class);
		OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
		ItemDao itemDao = sqlSession.getMapper(ItemDao.class);
		BookDao bookDao = sqlSession.getMapper(BookDao.class);
		UserBookDao userBookDao = sqlSession.getMapper(UserBookDao.class);
		BookChapterDao bookChapterDao = sqlSession.getMapper(BookChapterDao.class);
		try{
			if(address.getId() == null || "".equals(address.getId())){
				address.setId(UUID.randomUUID().toString());
				address.setUserId(user.getId());
				addressDao.insertOneAddress(address);
			}else{
				addressDao.updateAddress(address);
			}
			Order order = new Order();
			order.setId(UUID.randomUUID().toString());
			Date date = new Date();
			order.setOrderNo(String.valueOf(date.getTime()));
			session.setAttribute("orderNo", order.getOrderNo());
			order.setUserId(user.getId());
			order.setTotal(total);
			order.setCreateTime(date);
			order.setAddressId(address.getId());
			order.setStatus("未支付");
			orderDao.addOneOrder(order);
			HashMap<Book, Integer> trueMap = cart.get("实体书");
			if (trueMap != null){
				Set<Entry<Book,Integer>> set = trueMap.entrySet();
				for (Entry<Book, Integer> entry : set) {
					Item item = new Item();
					item.setId(UUID.randomUUID().toString());
					item.setCount(entry.getValue());
					item.setBookId(entry.getKey().getId());
					item.setCreateTime(date);
					item.setOrderId(order.getId());
					item.setTypee("实体书");
					itemDao.addOneItem(item);
					bookDao.updateBookCount(entry.getKey().getId(), entry.getValue());
				}
			}
			HashMap<Book, Integer> map = cart.get("电子书");
			if(map != null){
				Set<Entry<Book,Integer>> setmap = map.entrySet();
				for (Entry<Book, Integer> entry : setmap) {
					Item item = new Item();
					item.setId(UUID.randomUUID().toString());
					item.setCount(entry.getValue());
					item.setBookId(entry.getKey().getId());
					item.setCreateTime(date);
					item.setOrderId(order.getId());
					item.setTypee("电子书");
					itemDao.addOneItem(item);
					userBookDao.save(entry.getKey().getId(),user.getId());
					BookChapter bookChapter = new BookChapter();
					bookChapter.setChapter(1);
					bookChapter.setBook_id(entry.getKey().getId());
					bookChapter.setUser_id(user.getId());
					bookChapterDao.save(bookChapter);
					bookDao.updateSale(entry.getKey().getId(),entry.getValue());
				}
			}
			session.removeAttribute("cart");
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException("添加订单失败");
		}finally{
			MybatisUtils.close();
		}
	}

	/**
	 * 查找所有的订单，包括此订单所去向的地址
	 * @return
	 */
	@Override
	public List<Order> findAll() {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		OrderDao mapper = sqlSession.getMapper(OrderDao.class);
		List<Order> list = mapper.findAll();
		MybatisUtils.close();
		return list;
	}

	
	/**
	 * 按id查找一个订单
	 * @param id	订单id
	 * @return		查找到的订单
	 */
	@Override
	public Order findOneById(String id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession();
		OrderDao mapper = sqlSession.getMapper(OrderDao.class);
		Order order = mapper.findOneById(id);
		MybatisUtils.close();
		return order;
	}
}

























