package com.baizhi.service;

import java.util.List;

import com.baizhi.entity.Address;

public interface AddressService {
	/**
	 * 查找所有属于当前用户的地址
	 * @param userId	参数：当前用户的id
	 * @return		返回：属于当前用户的所有地址
	 */
	List<Address> findAllByUserId(String userId);
	
	/**
	 * 添加一个地址
	 * @param address	一个地址对象
	 */
	void insertOneAddress(Address address);
	
	/**
	 * 根据id查询对应的地址对象
	 * @param id
	 * @return
	 */
	Address findOneById(String id);
	
}










