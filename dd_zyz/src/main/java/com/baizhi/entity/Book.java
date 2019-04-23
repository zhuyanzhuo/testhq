package com.baizhi.entity;

import java.util.Date;

public class Book {
	private String id;
	private String name;//书名
	private String author;//作者
	private String cover;//封面
	private String press;//出版社
	private Date pressTime;//出版时间
	private String edition;//版次
	private Date revisionTime;//印刷时间
	private Integer printDate;//印次
	private String isbn;//isbn
	private Integer wordNum;//字数
	private Integer pageNum;//页数
	private Integer sizze;//开本
	private String paper;//纸张
	private String pack;//包装
	private Double price;//价格
	private Double ddprice;//当当价
	private Date createTime;//添加时间
	private String editorRecommend;//编辑推荐
	private String contentAbstract;//内容简介
	private String authorAbstract;//作者简介
	private String director;//目录
	private String mediaCommentary;//媒体评论
	private Integer sale;//销量
	private Integer stock;//库存
	private String categoryId;//分类id
	

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public Date getPressTime() {
		return pressTime;
	}

	public void setPressTime(Date pressTime) {
		this.pressTime = pressTime;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public Date getRevisionTime() {
		return revisionTime;
	}

	public void setRevisionTime(Date revisionTime) {
		this.revisionTime = revisionTime;
	}

	public Integer getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Integer printDate) {
		this.printDate = printDate;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getWordNum() {
		return wordNum;
	}

	public void setWordNum(Integer wordNum) {
		this.wordNum = wordNum;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getSizze() {
		return sizze;
	}

	public void setSizze(Integer sizze) {
		this.sizze = sizze;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDdprice() {
		return ddprice;
	}

	public void setDdprice(Double ddprice) {
		this.ddprice = ddprice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEditorRecommend() {
		return editorRecommend;
	}

	public void setEditorRecommend(String editorRecommend) {
		this.editorRecommend = editorRecommend;
	}

	public String getContentAbstract() {
		return contentAbstract;
	}

	public void setContentAbstract(String contentAbstract) {
		this.contentAbstract = contentAbstract;
	}

	public String getAuthorAbstract() {
		return authorAbstract;
	}

	public void setAuthorAbstract(String authorAbstract) {
		this.authorAbstract = authorAbstract;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getMediaCommentary() {
		return mediaCommentary;
	}

	public void setMediaCommentary(String mediaCommentary) {
		this.mediaCommentary = mediaCommentary;
	}

	public Integer getSale() {
		return sale;
	}

	public void setSale(Integer sale) {
		this.sale = sale;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String id, String name, String author, String cover, String press, Date pressTime, String edition,
			Date revisionTime, Integer printDate, String isbn, Integer wordNum, Integer pageNum, Integer sizze,
			String paper, String pack, Double price, Double ddprice, Date createTime, String editorRecommend,
			String contentAbstract, String authorAbstract, String director, String mediaCommentary, Integer sale,
			Integer stock, String categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.cover = cover;
		this.press = press;
		this.pressTime = pressTime;
		this.edition = edition;
		this.revisionTime = revisionTime;
		this.printDate = printDate;
		this.isbn = isbn;
		this.wordNum = wordNum;
		this.pageNum = pageNum;
		this.sizze = sizze;
		this.paper = paper;
		this.pack = pack;
		this.price = price;
		this.ddprice = ddprice;
		this.createTime = createTime;
		this.editorRecommend = editorRecommend;
		this.contentAbstract = contentAbstract;
		this.authorAbstract = authorAbstract;
		this.director = director;
		this.mediaCommentary = mediaCommentary;
		this.sale = sale;
		this.stock = stock;
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", cover=" + cover + ", press=" + press
				+ ", pressTime=" + pressTime + ", edition=" + edition + ", revisionTime=" + revisionTime
				+ ", printDate=" + printDate + ", isbn=" + isbn + ", wordNum=" + wordNum + ", pageNum=" + pageNum
				+ ", sizze=" + sizze + ", paper=" + paper + ", pack=" + pack + ", price=" + price + ", ddprice="
				+ ddprice + ", createTime=" + createTime + ", editorRecommend=" + editorRecommend + ", contentAbstract="
				+ contentAbstract + ", authorAbstract=" + authorAbstract + ", director=" + director
				+ ", mediaCommentary=" + mediaCommentary + ", sale=" + sale + ", stock=" + stock + ", categoryId="
				+ categoryId + "]";
	}

	
	
}










