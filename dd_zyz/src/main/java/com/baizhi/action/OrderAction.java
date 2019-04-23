package com.baizhi.action;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Address;
import com.baizhi.entity.Item;
import com.baizhi.entity.Order;
import com.baizhi.service.impl.ItemServiceImpl;
import com.baizhi.service.impl.OrderServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private Address address;
	private String message;
	private List<Order> orderAddress;
	private String id;
	private Order order;
	private List<Item> item;
	
	/**
	 * 添加一个订单
	 * 同时还要做的操作：
	 * 添加新地址或者修改原有地址
	 * 添加订单项
	 * 修改图书的销量和库存
	 * 移除购物车
	 * @return
	 */
	public String addOneOrder(){
		OrderServiceImpl impl = new OrderServiceImpl();
		try{
			if(address.getLocal().equals("") || address.getName().equals("") || address.getZipCodes().equals("") || address.getPhone().equals("")){
				throw new RuntimeException("所有信息都为必填项！");
			}
			impl.addOneOrder(address);
			return Action.SUCCESS;
		}catch(Exception e){
			message = e.getMessage();
			e.printStackTrace();
			return Action.ERROR;
		}
		
	}

	/**
	 * 查找所有的订单，包括此订单所去向的地址
	 * @return
	 */
	public String findAll(){
		OrderServiceImpl impl = new OrderServiceImpl();
		orderAddress = impl.findAll();
		return Action.SUCCESS;
	}
	
	/**
	 * 1,按id查找一个订单
	 * 2,按这个订单的id查找这个订单的所有订单项
	 * 3,根据订单项中的图书id查找所有的属于此订单的图书
	 */
	public String findOneOrderById(){
		OrderServiceImpl impl = new OrderServiceImpl();
		order = impl.findOneById(id);
		ItemServiceImpl itemImpl = new ItemServiceImpl();
		item = itemImpl.findItemBookByOrderId(id);
		return Action.SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Order> getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(List<Order> orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
}
