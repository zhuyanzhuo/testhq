package com.baizhi.action;

import java.util.List;
import java.util.UUID;

import com.baizhi.entity.Category;
import com.baizhi.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport{
	private List<Category> list;
	private Category category;
	private String name;
	private String id;
	private List<Category> parentList;
	private List<Category> secoundList;
	private List<Category> listSecound;

	/**
	 * 查找所有的一级和二级类别
	 * @return	返回：所有的类别
	 */
	public String findAll(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		list = impl.findAll();
		return Action.SUCCESS;
	}
	
	/**
	 * 查找所有的一级和二级分类（前台）
	 * @return
	 */
	public String frontFindAll(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		parentList = impl.findAllFirst();
		secoundList = impl.findAllSecound();
		return Action.SUCCESS;
	}
	
	/**
	 * 添加一个一级类别
	 * @return
	 */
	public String addParent(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		category.setId(UUID.randomUUID().toString());
		category.setLevels("1");
		category.setParent_id("");
		impl.addParentService(category);
		return Action.SUCCESS;
	}
	
	/**
	 * 添加一个二级类别
	 * @return
	 */
	public String addSecound(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		category.setId(UUID.randomUUID().toString());
		category.setLevels("2");
		category.setParent_id(name);
		impl.addSecoundService(category);
		return Action.SUCCESS;
	}
	
	/**
	 * 查找所有的一级类别
	 * @return
	 */
	public String findAllParent(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		list = impl.findAllFirst();
		return Action.SUCCESS;
	}
	
	/**
	 * 查找所有的二级类别
	 * @return
	 */
	public String findAllSecound(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		listSecound = impl.findAllSecound();
		return Action.SUCCESS;
	}
	
	/**
	 * 按id删除一个类别
	 * @return
	 */
	public String delete(){
		CategoryServiceImpl impl = new CategoryServiceImpl();
		impl.deleteService(id);
		return Action.SUCCESS;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Category> getList() {
		return list;
	}

	public void setList(List<Category> list) {
		this.list = list;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Category> getParentList() {
		return parentList;
	}

	public void setParentList(List<Category> parentList) {
		this.parentList = parentList;
	}

	public List<Category> getSecoundList() {
		return secoundList;
	}

	public void setSecoundList(List<Category> secoundList) {
		this.secoundList = secoundList;
	}

	public List<Category> getListSecound() {
		return listSecound;
	}

	public void setListSecound(List<Category> listSecound) {
		this.listSecound = listSecound;
	}
	
	
}









