package com.baizhi.entity;

public class UserBook {
	private String user_id;
	private String book_id;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public UserBook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserBook(String user_id, String book_id) {
		super();
		this.user_id = user_id;
		this.book_id = book_id;
	}
	@Override
	public String toString() {
		return "UserBook [user_id=" + user_id + ", book_id=" + book_id + "]";
	}
	
	
}
