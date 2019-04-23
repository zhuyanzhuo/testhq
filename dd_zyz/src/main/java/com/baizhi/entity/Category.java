package com.baizhi.entity;

import java.util.List;

public class Category {
	private String id;
	private String name;
	private String levels;
	private String parent_id;
	
	private Category first;
	private List<Category> secound;
	private List<Book> books;

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

	public String getLevels() {
		return levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	
	

	public List<Category> getSecound() {
		return secound;
	}

	public void setSecound(List<Category> secound) {
		this.secound = secound;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Category getFirst() {
		return first;
	}

	public void setFirst(Category first) {
		this.first = first;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Category(String id, String name, String parent_id, String levels) {
		super();
		this.id = id;
		this.name = name;
		this.levels = levels;
		this.parent_id = parent_id;
	}

	

	public Category(String id, String name, String levels, String parent_id, Category first) {
		super();
		this.id = id;
		this.name = name;
		this.levels = levels;
		this.parent_id = parent_id;
		this.first = first;
	}
	
	

	public Category(String id, String name, String levels, String parent_id, Category first, List<Category> secound,
			List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.levels = levels;
		this.parent_id = parent_id;
		this.first = first;
		this.secound = secound;
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", levels=" + levels + "]";
	}
	
	
}
