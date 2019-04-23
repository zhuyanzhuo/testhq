package com.baizhi.action;

import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.impl.AddressServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport{
	private List<Address> addressList;
	private Address address;
	private String addressId;
	private Double total;
	private String name;
	private String local;
	private String zipCodes;
	private String phone;
	/**
	 * 查找与当前用户相关的所有地址
	 * @return
	 */
	public String selectAll(){
		AddressServiceImpl impl = new AddressServiceImpl();
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		addressList = impl.findAllByUserId(user.getId());
		ServletActionContext.getRequest().getSession().setAttribute("total", total);
		return Action.SUCCESS;
	}
	
	/**
	 * 为地址对象添加
	 * 收件人，详细地址，邮编，电话字段并传递给下一个action
	 * @return
	 */
	public String addOne(){
		address = new Address();
		address.setName(name);
		address.setLocal(local);
		address.setZipCodes(zipCodes);
		address.setPhone(phone);
		return Action.SUCCESS;
	}

	/**
	 * 地址的回显，前台页面用户点击一个已经存在的地址时回显地址，同时还要将有关当前用户的所有地址重新回显
	 * @return
	 */
	public String selectAddressByAddressId(){
		AddressServiceImpl impl = new AddressServiceImpl();
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		addressList = impl.findAllByUserId(user.getId());
		if(addressId == null || "".equals(addressId)){
			return Action.SUCCESS;
		}else{
			address = impl.findOneById(addressId);
			return Action.SUCCESS;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
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
	
	
}









