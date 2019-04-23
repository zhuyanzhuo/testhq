package com.baizhi.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.service.impl.BookServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport{
	private Integer num;
	private String id;
	private String type;
	private String des;
	
	/**
	 * 接收用户购买的图书，存入Map集合中，并将Map存入Session中作为购物车
	 * 需判断用户选择的是实体书还是电子版
	 */
	
	public String cart(){
		BookServiceImpl impl = new BookServiceImpl();
		Book book = impl.findOne(id);
		HttpSession session = ServletActionContext.getRequest().getSession();
		HashMap<String,HashMap<Book,Integer>> cart = (HashMap<String,HashMap<Book,Integer>>)session.getAttribute("cart");
		if(cart == null){
			cart = new HashMap<String,HashMap<Book,Integer>>();
			HashMap<Book, Integer> map = new HashMap<>();
			map.put(book, 1);
			if(type == null || "".equals(type)){
				cart.put("实体书",map);
			}else{
				cart.put("电子书",map);
			}
			session.setAttribute("cart", cart);
		}else{
			if(type == null || "".equals(type)){
				int m = 0;
				HashMap<Book, Integer> trueMap = cart.get("实体书");
				if (trueMap != null){
					Set<Entry<Book,Integer>> set = trueMap.entrySet();
					for (Entry<Book, Integer> entry : set) {
						Book key = entry.getKey();
						Integer value = entry.getValue();
						if(book.getId().equals(key.getId())){
							trueMap.put(key, ++value);
							m++;
						}
					}
					if(m == 0){
						trueMap.put(book, 1);
					}
				}else{
					trueMap = new HashMap<Book,Integer>();
					trueMap.put(book,1);
					cart.put("实体书",trueMap);
				}
			}else{
				HashMap<Book, Integer> map = cart.get("电子书");
				if(map != null){
					Set<Entry<Book, Integer>> set = map.entrySet();
					for (Entry<Book,Integer> entry: set) {
						Book key = entry.getKey();
						Integer value = entry.getValue();
						if (book.getId().equals(key.getId())){
							map.remove(key);
							map.put(book,1);
						}
					}
				}else{
					map = new HashMap<Book,Integer>();
					map.put(book,1);
					cart.put("电子书",map);
				}
			}
			session.setAttribute("cart", cart);
		}
		return Action.SUCCESS;
	}

	
	/**
	 * 按id修改一本图书的购买数量
	 * 电子书只有一本，不需要变更数量
	 */
	
	public String updateNum(){
		BookServiceImpl impl = new BookServiceImpl();
		Book book = impl.findOne(id);
		HttpSession session = ServletActionContext.getRequest().getSession();
		HashMap<String,HashMap<Book,Integer>> cart = (HashMap<String,HashMap<Book,Integer>>)session.getAttribute("cart");
		HashMap<Book, Integer> map = cart.get("实体书");
		Set<Entry<Book,Integer>> set = map.entrySet();
		for (Entry<Book, Integer> entry : set) {
			Book key = entry.getKey();
			if(book.getId().equals(key.getId())){
				map.put(key, num);
			}
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 按id删除一本购物车中的一本图书
	 * @return
	 */
	
	public String deleteFromCartById(){
		BookServiceImpl impl = new BookServiceImpl();
		Book book = impl.findOne(id);
		HttpSession session = ServletActionContext.getRequest().getSession();
		HashMap<String,HashMap<Book,Integer>> cart = (HashMap<String,HashMap<Book,Integer>>)session.getAttribute("cart");
		if (("实体书").equals(des)){
			HashMap<Book, Integer> map = cart.get("实体书");
			Set<Entry<Book,Integer>> set = map.entrySet();
			for (Entry<Book, Integer> entry : set) {
				Book key = entry.getKey();
				if(book.getId().equals(key.getId())){
					map.remove(key);
				}
			}
			if (map == null){
				cart.remove("实体书");
			}
		}
		if (("电子书").equals(des)){
			HashMap<Book, Integer> map = cart.get("电子书");
			Set<Entry<Book,Integer>> set = map.entrySet();
			for (Entry<Book, Integer> entry : set) {
				Book key = entry.getKey();
				if(book.getId().equals(key.getId())){
					map.remove(key);
				}
			}
			if(map == null){
				cart.remove("电子书");
			}
		}
		return Action.SUCCESS;
	}





	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	
}













