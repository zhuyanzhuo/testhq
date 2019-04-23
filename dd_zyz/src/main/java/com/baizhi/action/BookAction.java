package com.baizhi.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	private List<Book> list;
	private String id;
	private Book book;//图书对象
	private String bookName;//图书名
	private String author;//作者
	private String press;//出版社
	private String cover;//封面（文件）
	private String coverFileName;//封面文件的名称
	private List<Category> listCategory;
	private String key;
	private String content;
	private String message;
	private List<Category> listSecound;
	
	

	/**
	 * 查询所有图书
	 * @return	返回：所有图书的集合
	 */
	public String queryAll(){
		BookServiceImpl impl = new BookServiceImpl();
		list = impl.findAll();
		return Action.SUCCESS;
	}
	
	/**
	 * 按id查询一本图书，将结果返回
	 * 同时查询所有的二级目录
	 * @return
	 */
	public String queryById(){
		BookServiceImpl impl = new BookServiceImpl();
		book = impl.findOne(id);
		CategoryServiceImpl impl2 = new CategoryServiceImpl();
		listCategory = impl2.findAllSecound();
		return Action.SUCCESS;
	}
	/**
	 * 添加一本图书
	 * 对于封面，需要进行缓存。
	 * @return
	 * @throws IOException 
	 */
	public String addOneBook() throws IOException{
		FileInputStream is = new FileInputStream(cover);
		String realPath = ServletActionContext.getRequest().getRealPath("back/img/");
		FileOutputStream os = new FileOutputStream(new File(realPath,coverFileName));
		IOUtils.copy(is, os);
		IOUtils.closeQuietly(is);
		IOUtils.closeQuietly(os);
		book.setId(UUID.randomUUID().toString().replace("-", ""));
		book.setSale(0);
		book.setCover("/back/img/"+coverFileName);
		BookServiceImpl impl = new BookServiceImpl();
		impl.addOneBook(book);
		return Action.SUCCESS;
	}
	
	/**
	 * 按id删除一本图书
	 * @return
	 */
	public String deleteOneBook(){
		String[] split = cover.split("/");
		String realPath = ServletActionContext.getRequest().getRealPath("back/img/");
		new File(realPath,split[3]).delete();
		BookServiceImpl impl = new BookServiceImpl();
		impl.deleteOneBook(id);
		return Action.SUCCESS;
	}
	
	/**
	 * 修改一本图书
	 * @return
	 * @throws Exception 
	 */
	public String updateOneBook() throws Exception{
		if(cover == null){
			BookServiceImpl impl = new BookServiceImpl();
			impl.updateOneBook(book);
			return Action.SUCCESS;
		}else{
			BookServiceImpl impl = new BookServiceImpl();
			String id2 = book.getId();
			Book book2 = impl.findOne(id2);
			String cover2 = book2.getCover();
			String[] split = cover2.split("/");
			String realPath = ServletActionContext.getRequest().getRealPath("back/img/");
			new File(realPath,split[3]).delete();
			FileInputStream is = new FileInputStream(cover);
			FileOutputStream os = new FileOutputStream(new File(realPath,coverFileName));
			IOUtils.copy(is, os);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
			book.setCover("/back/img/"+coverFileName);
			impl.updateOneBook(book);
			return Action.SUCCESS;
		}
	}
	
	/**
	 * 按书名模糊查询
	 * @return	返回：目标图书的集合
	 */
	public String queryByName(){
		BookServiceImpl impl = new BookServiceImpl();
		list = impl.findByName(bookName);
		return Action.SUCCESS;
	}
	
	/**
	 * 按作者模糊查询
	 * @return	返回：目标图书的集合
	 */
	public String queryByAuthor(){
		BookServiceImpl impl = new BookServiceImpl();
		list = impl.findByAuthor(author);
		return Action.SUCCESS;
	}
	
	/**
	 * 按出版社模糊查询
	 * @return	返回：目标图书集合
	 */
	public String queryByPress(){
		BookServiceImpl impl = new BookServiceImpl();
		list = impl.findByPress(press);
		return Action.SUCCESS;
	}

	/**
	 * 按条件模糊查询
	 * @return	
	 */
	public String queryByContent(){
		BookServiceImpl impl = new BookServiceImpl();
		if(key.equals("name")){
			list = impl.findByName(content);
			return Action.SUCCESS;
		}else if(key.equals("author")){
			list = impl.findByAuthor(content);
			return Action.SUCCESS;
		}else{
			list = impl.findByPress(content);
			return Action.SUCCESS;
		}
	}

	/**
	 * 按id查询一本图书
	 * @return
	 */
	public String findOne(String id){
		BookServiceImpl bookService = new BookServiceImpl();
		book = bookService.findOne(id);
		return Action.SUCCESS;
	}
	
	
	
	
	
	
	
	public List<Book> getList() {
		return list;
	}
	public void setList(List<Book> list) {
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getCoverFileName() {
		return coverFileName;
	}
	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Category> getListSecound() {
		return listSecound;
	}

	public void setListSecound(List<Category> listSecound) {
		this.listSecound = listSecound;
	}
	
	
}




















