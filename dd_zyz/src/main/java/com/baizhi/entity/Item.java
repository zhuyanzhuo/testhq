package com.baizhi.entity;

import java.util.Date;

public class Item {
	private String id;
	private String bookId;
	private Integer count;
	private Date createTime;
	private String orderId;
	private String typee;
	
	private Book book;

	public Item(String id, String bookId, Integer count, Date createTime, String orderId, String typee, Book book) {
		this.id = id;
		this.bookId = bookId;
		this.count = count;
		this.createTime = createTime;
		this.orderId = orderId;
		this.typee = typee;
		this.book = book;
	}

	public Item(String id, String bookId, Integer count, Date createTime, String orderId, String typee) {
		this.id = id;
		this.bookId = bookId;
		this.count = count;
		this.createTime = createTime;
		this.orderId = orderId;
		this.typee = typee;
	}

	public Item() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTypee() {
		return typee;
	}

	public void setTypee(String typee) {
		this.typee = typee;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id='" + id + '\'' +
				", bookId='" + bookId + '\'' +
				", count=" + count +
				", createTime=" + createTime +
				", orderId='" + orderId + '\'' +
				", typee='" + typee + '\'' +
				", book=" + book +
				'}';
	}
}
