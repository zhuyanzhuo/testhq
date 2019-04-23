package com.baizhi.entity;

public class Ebook {
	private String id;
	private String name;
	private Integer grade;
	private Integer chapter;
	private Integer like_num;
	private String book_id;
	public Ebook() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ebook(String id, String name, Integer grade, Integer chapter, Integer like_num, String book_id) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.chapter = chapter;
		this.like_num = like_num;
		this.book_id = book_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Integer getChapter() {
		return chapter;
	}
	public void setChapter(Integer chapter) {
		this.chapter = chapter;
	}
	public Integer getLike_num() {
		return like_num;
	}
	public void setLike_num(Integer like_num) {
		this.like_num = like_num;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	@Override
	public String toString() {
		return "Ebook [id=" + id + ", name=" + name + ", grade=" + grade + ", chapter=" + chapter + ", like_num="
				+ like_num + ", book_id=" + book_id + "]";
	}
	
	
}
