package com.baizhi.action;

import java.util.List;

import com.baizhi.entity.User;
import com.baizhi.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class BackUserAction extends ActionSupport{
	
	private List<User> userList;
	private String id;
	private User user;
	private String status;

	/**
	 * 后台：显示所有用户
	 * @return
	 */
	public String showAll(){
		UserServiceImpl impl = new UserServiceImpl();
		userList = impl.showAll();
		return Action.SUCCESS;
	}

	/**
	 * 修改用户的状态
	 * 如果是激活就改为冻结
	 * 如果是冻结就改为激活
	 * @return
	 */
	public String updateStatus(){
		UserServiceImpl impl = new UserServiceImpl();
		user = impl.findOneService(id);
		if("正常".equals(user.getStatus())){
			status = "冻结";
			impl.updateStatus(id, status);
			return Action.SUCCESS;
		}else{
			status = "正常";
			impl.updateStatus(id, status);
			return Action.SUCCESS;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}









