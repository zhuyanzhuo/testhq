package com.baizhi.entity;

import java.util.Date;

public class Book {
	private String id;
	private String name;//书名
	private String author;//作者
	private String cover;//封面
	private String press;//出版社
	private String edition;//版次
	private Integer printDate;//印次
	private String isbn;//isbn
	private Integer wordNum;//字数
	private Double price;//价格
	private Double ddprice;//本站价
	private Date createTime;//添加时间
	private String editorRecommend;//编辑推荐
	private String contentAbstract;//内容简介
	private Integer sale;//销量
	private Integer stock;//库存
	private String categoryId;//分类id

	public Book() {
	}

	public Book(String id, String name, String author, String cover, String press, String edition, Integer printDate, String isbn, Integer wordNum, Double price, Double ddprice, Date createTime, String editorRecommend, String contentAbstract, Integer sale, Integer stock, String categoryId) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.cover = cover;
		this.press = press;
		this.edition = edition;
		this.printDate = printDate;
		this.isbn = isbn;
		this.wordNum = wordNum;
		this.price = price;
		this.ddprice = ddprice;
		this.createTime = createTime;
		this.editorRecommend = editorRecommend;
		this.contentAbstract = contentAbstract;
		this.sale = sale;
		this.stock = stock;
		this.categoryId = categoryId;
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

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
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

	@Override
	public String toString() {
		return "Book{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", author='" + author + '\'' +
				", cover='" + cover + '\'' +
				", press='" + press + '\'' +
				", edition='" + edition + '\'' +
				", printDate=" + printDate +
				", isbn='" + isbn + '\'' +
				", wordNum=" + wordNum +
				", price=" + price +
				", ddprice=" + ddprice +
				", createTime=" + createTime +
				", editorRecommend='" + editorRecommend + '\'' +
				", contentAbstract='" + contentAbstract + '\'' +
				", sale=" + sale +
				", stock=" + stock +
				", categoryId='" + categoryId + '\'' +
				'}';
	}
}










