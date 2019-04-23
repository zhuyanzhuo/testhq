package com.baizhi.action;

import java.util.ArrayList;
import java.util.List;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FrontSecoundViewAction extends ActionSupport{
	private String id;
	private String sid;
	private List<Category> secound;
	private List<Book> books;
	private List<Book> secoundBooks;
	private Category FirstCategory;
	private Category SecoundCategory;
	private Book book;
	private Integer total;
	private Integer page;
	private List<Book> pageBooks;

	/**
	 * 根据传过来的一个一级类别的id查找所有的属于这个一级类别的二级类别
	 * 同时查找出所有的二级类别下的所有图书
	 */
	public String findFirstAndSecoundAndBook(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		FirstCategory = impl.findFirstAndSecoundAndBook(id);
		secound = FirstCategory.getSecound();
		books = FirstCategory.getBooks();
		Integer count = books.size();
		total = impl.total(count);
		if(page == null){
			page = 1;
		}
		Integer end = page * 3;
		pageBooks = new ArrayList<Book>();
		if((end - 3) <= books.size() - 1){
			Book timeBook1 = books.get(end - 3 );
			pageBooks.add(timeBook1);
		}
		if((end - 2) <= books.size() - 1){
			Book timeBook2 = books.get(end - 2);
			pageBooks.add(timeBook2);
		}
		if((end - 1) <= books.size() - 1){
			Book timeBook3 = books.get(end - 1);
			pageBooks.add(timeBook3);
		}
		
		return Action.SUCCESS;
	}

	/**
	 * 根据一个二级类别查找此二级类别下的所有图书
	 */
	public String findBookBySecound(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		FirstCategory = impl.findFirstAndSecoundAndBook(id);
		secound = FirstCategory.getSecound();
		for (Category ca : secound) {
			if(sid.equals(ca.getId())){
				SecoundCategory = ca;
				books = ca.getBooks();
				Integer count = books.size();
				total = impl.total(count);
				if(page == null){
					page = 1;
				}
				Integer end = page * 3;
				pageBooks = new ArrayList<Book>();
				if((end - 3) <= books.size() - 1){
					Book timeBook1 = books.get(end - 3 );
					pageBooks.add(timeBook1);
				}
				if((end - 2) <= books.size() - 1){
					Book timeBook2 = books.get(end - 2);
					pageBooks.add(timeBook2);
				}
				if((end - 1) <= books.size() - 1){
					Book timeBook3 = books.get(end - 1);
					pageBooks.add(timeBook3);
				}
			}
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 按id查找一本图书（二级页面）
	 * @return	返回值：返回一个图书对象
	 */
	public String findOneBookById(){
		BookServiceImpl impl = new BookServiceImpl();
		book = impl.findOne(id);
		return Action.SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Category getFirstCategory() {
		return FirstCategory;
	}

	public void setFirstCategory(Category firstCategory) {
		FirstCategory = firstCategory;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public List<Book> getSecoundBooks() {
		return secoundBooks;
	}

	public void setSecoundBooks(List<Book> secoundBooks) {
		this.secoundBooks = secoundBooks;
	}

	public Category getSecoundCategory() {
		return SecoundCategory;
	}

	public void setSecoundCategory(Category secoundCategory) {
		SecoundCategory = secoundCategory;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public List<Book> getPageBooks() {
		return pageBooks;
	}

	public void setPageBooks(List<Book> pageBooks) {
		this.pageBooks = pageBooks;
	}
	
	
}












