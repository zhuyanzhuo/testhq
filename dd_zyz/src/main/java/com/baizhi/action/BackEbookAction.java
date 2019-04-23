package com.baizhi.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.Ebook;
import com.baizhi.service.impl.BookServiceImpl;
import com.baizhi.service.impl.EbookServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class BackEbookAction extends ActionSupport {
	
	private List<Book> list;
	private String id;
	private Integer chapter;
	private Integer count;
	private Book book;
	private Map<String,Integer> map;
	private List<String> para;
	private List<String> paraFileName;
	private String sub;
	
	public String findAllBook(){
		BookServiceImpl impl = new BookServiceImpl();
		list = impl.findAll();
		return Action.SUCCESS;
	}

	public String findOneBook(){
		BookServiceImpl impl = new BookServiceImpl();
		book = impl.findOne(id);
		chapter = 1;
		return Action.SUCCESS;
	}
	
	public String middleAdd(){
		BookServiceImpl impl = new BookServiceImpl();
		book = impl.findOne(id);
		map = new LinkedHashMap<String,Integer>();
		for(int i=1;i<=count;i++){
			map.put("第"+i+"段", i);
		}
		return Action.SUCCESS;
	}
	
	public String addEbook() throws IOException{
		for(int i = 0;i < para.size();i++){
			FileInputStream is = new FileInputStream(para.get(i));
			String str = chapter.toString();
			String realPath = ServletActionContext.getRequest().getRealPath("back/ebook"+"/"+id+"/"+str+"/");
			File filet=new File(realPath);
	        if(!filet.exists()){
	            filet.mkdirs();
	        }
			FileOutputStream os = new FileOutputStream(new File(realPath,paraFileName.get(i)));
			IOUtils.copy(is, os);
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(os);
			Ebook ebook = new Ebook();
			ebook.setId(UUID.randomUUID().toString());
			ebook.setName(paraFileName.get(i));
			ebook.setGrade(i+1);
			ebook.setChapter(chapter);
			ebook.setLike_num(0);
			ebook.setBook_id(id);
			EbookServiceImpl impl = new EbookServiceImpl();
			Ebook findOne = impl.findOne(id, chapter, i+1);
			if(findOne == null){
				impl.save(ebook);
			}else{
				impl.deleteOne(findOne.getId());
				impl.save(ebook);
			}
		}
		if(sub.equals("提交")){
			chapter = chapter + 1;
			BookServiceImpl impl = new BookServiceImpl();
			book = impl.findOne(id);
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
		
		
		/*for(int i =0;i < para.size();i++){
			System.out.println(paraFileName.get(i));
		}*/
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public List<String> getPara() {
		return para;
	}

	public void setPara(List<String> para) {
		this.para = para;
	}

	public List<String> getParaFileName() {
		return paraFileName;
	}

	public void setParaFileName(List<String> paraFileName) {
		this.paraFileName = paraFileName;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public Integer getChapter() {
		return chapter;
	}

	public void setChapter(Integer chapter) {
		this.chapter = chapter;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
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
	

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

}
