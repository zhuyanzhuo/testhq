package com.baizhi.entity;

public class Address {
	private String id;
	private String name;
	private String local;
	private String zipCodes;
	private String phone;
	private String userId;
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
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getZipCodes() {
		return zipCodes;
	}
	public void setZipCodes(String zipCodes) {
		this.zipCodes = zipCodes;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String id, String name, String local, String zipCodes, String phone, String userId) {
		super();
		this.id = id;
		this.name = name;
		this.local = local;
		this.zipCodes = zipCodes;
		this.phone = phone;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", name=" + name + ", local=" + local + ", zipCodes=" + zipCodes + ", phone="
				+ phone + ", userId=" + userId + "]";
	}
	
	
}
