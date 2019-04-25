package com.baizhi.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.BookChapter;
import com.baizhi.entity.Ebook;
import com.baizhi.entity.User;
import com.baizhi.service.impl.BookChapterServiceImpl;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.EbookServiceImpl;
import com.baizhi.service.impl.UserBookServiceImpl;
import com.opensymphony.xwork2.Action;

public class FrontEbookAction {
	private String id;
	private Map<String,List<String>> map;
	private Book book;
	private String strChap;
	private String maxStrChap;
	private String mark;
	private List<Integer> list;
	private String chapter;

	
	/**
	 * 为用户——图书表和书签表进行信息存储
	 * @return
	 */
	public String saveMessage(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		UserBookServiceImpl userBookServiceImpl = new UserBookServiceImpl();
		userBookServiceImpl.save(id, user.getId());
		BookChapter bookChapter = new BookChapter();
		bookChapter.setChapter(1);
		bookChapter.setBook_id(id);
		bookChapter.setUser_id(user.getId());
		BookChapterServiceImpl impl = new BookChapterServiceImpl();
		impl.save(bookChapter);
		return Action.SUCCESS;
	}

	/**
	 * 当用户点击其所有的一部电子书之后，先进行书签表的查询，
	 * 如果书签表中没有记录用户的书签信息，则进入目录页面，
	 * 如果书签表有信息，则根据书签中记录的章节
	 * 查找此章节下的所有段落，并按顺序展示出来
	 * 同时将本书的最大章节数查询出来
	 * @return
	 */
	public String findChapter(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		BookChapterServiceImpl bcimpl = new BookChapterServiceImpl();
		BookServiceImpl bookImpl = new BookServiceImpl();
		book = bookImpl.findOne(id);
		BookChapter bookChapter = bcimpl.findByBookAndUser(id, user.getId());
		if(bookChapter != null){
			Integer chap = bookChapter.getChapter();
			strChap = chap.toString();
			EbookServiceImpl ebookServiceImpl = new EbookServiceImpl();
			List<Ebook> listGrade = ebookServiceImpl.findAll(id, chap);
			map = new LinkedHashMap<String,List<String>>();
			for(Ebook ebook:listGrade){
				List<String> list = new ArrayList<String>();
				String name = ebook.getName();
				String eid = ebook.getId();
				String cp = ebook.getChapter().toString();
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
			}
			Integer maxChapter = ebookServiceImpl.findMaxChapter(id);
			maxStrChap = maxChapter.toString();
			return Action.SUCCESS;
		}else{
			EbookServiceImpl ebookServiceImpl = new EbookServiceImpl();
			list = ebookServiceImpl.findAllChapter(id);
			return Action.ERROR;
		}
	}

	/**
	 * 当用户点击某一个章节时，为书签表创建一个记录第几个章节的书签
	 * 如果已经存在一个书签，那么修改它
	 * @return
	 */
	public String saveChapter(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		BookChapterServiceImpl bookChapterService = new BookChapterServiceImpl();
		BookChapter bookChapter = new BookChapter();
		bookChapter.setUser_id(user.getId());
		bookChapter.setBook_id(id);
		Integer value = Integer.valueOf(chapter);
		bookChapter.setChapter(value);
		BookChapter byBookAndUser = bookChapterService.findByBookAndUser(id,user.getId());
		if(byBookAndUser == null){
			bookChapterService.save(bookChapter);
		}else{
			bookChapterService.updateChapter(bookChapter);
		}
		BookServiceImpl bookService = new BookServiceImpl();
		Book book = bookService.findOne(id);
		id = book.getId();
		return Action.SUCCESS;
	}

	/**
	 * 当用户从电子书内容跳转到目录时的方法
	 * @return
	 */
	public String showChapter(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		BookServiceImpl bookImpl = new BookServiceImpl();
		book = bookImpl.findOne(id);
		EbookServiceImpl ebookServiceImpl = new EbookServiceImpl();
		list = ebookServiceImpl.findAllChapter(id);
		return Action.SUCCESS;
	}

	/**
	 * 当用户点击上一页下一页时更改书签
	 * @return
	 */
	public String updateChapter(){
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		BookChapter bookChapter = new BookChapter();
		Integer chap = Integer.valueOf(strChap);
		if(mark.equals("del")){
			--chap;
		}else if(mark.equals("add")){
			++chap;
		}
		bookChapter.setUser_id(user.getId());
		bookChapter.setBook_id(id);
		bookChapter.setChapter(chap);
		BookChapterServiceImpl impl = new BookChapterServiceImpl();
		impl.updateChapter(bookChapter);
		id = bookChapter.getBook_id();
		return Action.SUCCESS;
	}
	
	/**
	 * 接收用户的点赞请求，接收到用户要点赞的段落id，将此段落点赞数+1
	 * @return
	 */
	public String addLikeNum(){
		EbookServiceImpl impl = new EbookServiceImpl();
		impl.addLikeNum(id);
		return Action.NONE;
	}







	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getMaxStrChap() {
		return maxStrChap;
	}

	public void setMaxStrChap(String maxStrChap) {
		this.maxStrChap = maxStrChap;
	}

	public String getStrChap() {
		return strChap;
	}

	public void setStrChap(String strChap) {
		this.strChap = strChap;
	}

	public Map<String, List<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
