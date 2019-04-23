package com.baizhi.Interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserInterceptor extends AbstractInterceptor{

	
	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		//获得sesssion
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		//判断user是否存在
		if(user==null){
			//不存在  return 登录界面
			return "login";
		}else{
			if(user.getKey()==null||user.getKey().equals("")){
				//判断user.code是否为空或者为null return 邮箱激活页面
				return "email";
			}else{
				ai.invoke();
			}
		}
		return null;
	}
}


