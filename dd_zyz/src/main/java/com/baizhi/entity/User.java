package com.baizhi.entity;

import java.util.Date;
import java.util.List;

public class User {
	private String id;//id
	private String email;//邮箱
	private String password;//密码
	private String salt;//加密密钥
	private String nickname;//昵称
	private String status;//状态
	private String key;//激活码
	private Date createTime;//创建时间
	
	private List<Book> books;
	
	
	
	public User(String id, String email, String password, String salt, String nickname, String status, String key,
			Date createTime, List<Book> books) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.nickname = nickname;
		this.status = status;
		this.key = key;
		this.createTime = createTime;
		this.books = books;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String email, String password, String salt, String nickname, String status, String key,
			Date createTime) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.nickname = nickname;
		this.status = status;
		this.key = key;
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", salt=" + salt + ", nickname="
				+ nickname + ", status=" + status + ", key=" + key + ", createTime=" + createTime + "]";
	}
	
	
}
