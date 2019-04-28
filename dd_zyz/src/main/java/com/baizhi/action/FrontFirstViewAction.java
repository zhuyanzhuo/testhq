package com.baizhi.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Category;
import com.baizhi.entity.Ebook;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.baizhi.service.impl.EbookServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FrontFirstViewAction extends ActionSupport{
	private List<Category> allFirst;
	private List<Category> allSecound;
	private List<Book> recommendList;
	private List<Book> saleBookList;
	private List<Book> createTimeBookList;
	private List<Book> newAndCreateTimeList;
	private String id;
	private Book book;
	private Map<String,List<String>> map;

	/**
	 * 获取一级分类
	 * 获取二级分类
	 * 查询编辑推荐的两本图书
	 * 查询销量前8的图书
	 * 查询最新上架的8本图书
	 * 查询新书热卖的10本图书
	 */
	public String frontFirstView(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		allFirst = impl.findAllFirst();
		allSecound = impl.findAllSecound();
		BookServiceImpl impl2 = new BookServiceImpl();
		recommendList = impl2.selectByRecommend();
		saleBookList = impl2.selectBookBySale();
		createTimeBookList = impl2.selectBookByCreateTime();
		newAndCreateTimeList = impl2.selectBookByNewAndCreateTime();
		return Action.SUCCESS;
	}
	
	/**
	 * 按id查询一本图书，当用户单击图书的名称或是封面时
	 * @return	将返回用户所点击的图书的对象
	 */
	public String findOneById(){
		BookServiceImpl impl = new BookServiceImpl();
		book = impl.findOne(id);
		map = new LinkedHashMap<String,List<String>>();
		EbookServiceImpl ebookServiceImpl = new EbookServiceImpl();
		Ebook byLikeNum = ebookServiceImpl.findByLikeNum(id);
		List<String> list = new ArrayList<String>();
		String name = byLikeNum.getName();
		String eid = byLikeNum.getId();
		String cp = byLikeNum.getChapter().toString();
		String realPath = ServletActionContext.getRequest().getRealPath("back/ebook"+"/"+id+"/"+cp+"/");
		try{
			File file = new File(realPath,name);
			FileInputStream fs = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs, "UTF-8"));
			String str;
			while((str = br.readLine()) != null){
				list.add(str);
			}
			br.close();
			fs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		map.put(eid, list);
		return Action.SUCCESS;
	}
	
	/**
	 * 移除购物车中的total
	 * @return
	 */
	public String removeTotal(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("total");
		return Action.SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Map<String, List<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}

	public List<Category> getAllFirst() {
		return allFirst;
	}
	public void setAllFirst(List<Category> allFirst) {
		this.allFirst = allFirst;
	}
	public List<Category> getAllSecound() {
		return allSecound;
	}
	public void setAllSecound(List<Category> allSecound) {
		this.allSecound = allSecound;
	}
	public List<Book> getRecommendList() {
		return recommendList;
	}
	public void setRecommendList(List<Book> recommendList) {
		this.recommendList = recommendList;
	}
	public List<Book> getSaleBookList() {
		return saleBookList;
	}
	public void setSaleBookList(List<Book> saleBookList) {
		this.saleBookList = saleBookList;
	}
	public List<Book> getCreateTimeBookList() {
		return createTimeBookList;
	}
	public void setCreateTimeBookList(List<Book> createTimeBookList) {
		this.createTimeBookList = createTimeBookList;
	}
	public List<Book> getNewAndCreateTimeList() {
		return newAndCreateTimeList;
	}
	public void setNewAndCreateTimeList(List<Book> newAndCreateTimeList) {
		this.newAndCreateTimeList = newAndCreateTimeList;
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
	
	
}








