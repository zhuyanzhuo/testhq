package com.baizhi.entity;

import java.util.Date;

public class Order {
	private String id;
	private String orderNo;
	private Double total;
	private Date createTime;
	private String status;
	private String addressId;
	private String userId;
	private Address address;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, String orderNo, Double total, Date createTime, String status, String addressId,
			String userId) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.total = total;
		this.createTime = createTime;
		this.status = status;
		this.addressId = addressId;
		this.userId = userId;
	}
	
	
	public Order(String id, String orderNo, Double total, Date createTime, String status, String addressId,
			String userId, Address address) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.total = total;
		this.createTime = createTime;
		this.status = status;
		this.addressId = addressId;
		this.userId = userId;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", total=" + total + ", createTime=" + createTime
				+ ", status=" + status + ", addressId=" + addressId + ", userId=" + userId + "]";
	}
	
	
}
