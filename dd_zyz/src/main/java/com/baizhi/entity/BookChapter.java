package com.baizhi.entity;

public class BookChapter {
	private String book_id;
	private String user_id;
	private Integer chapter;
	public BookChapter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookChapter(String book_id, String user_id, Integer chapter) {
		super();
		this.book_id = book_id;
		this.user_id = user_id;
		this.chapter = chapter;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Integer getChapter() {
		return chapter;
	}
	public void setChapter(Integer chapter) {
		this.chapter = chapter;
	}
	@Override
	public String toString() {
		return "BookChapter [book_id=" + book_id + ", user_id=" + user_id + ", chapter=" + chapter + "]";
	}
	
	
}
