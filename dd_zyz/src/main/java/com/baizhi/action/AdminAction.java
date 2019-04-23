package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.baizhi.service.impl.AdminServiceImpl;
import com.baizhi.util.VerifyCodeUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private String username;
	private String password;
	private String message;
	private String judgeCode;

	/**
	 * 接收输入的用户名，去数据库中查找对应用户，如果用户存在，则返回此用户并继续比对输入的密码是否与
	 * 所查询出的用户密码相同，如果相同，则登陆成功。如果用户不存在，输出错误信息。
	 * 如果不同则输出错误信息。
	 * @return
	 */
	public String login(){
		String code = (String)ServletActionContext.getRequest().getSession().getAttribute("code");
		AdminServiceImpl impl = new AdminServiceImpl();
		Admin admin = impl.loginService(username);
		if(!code.equalsIgnoreCase(judgeCode)){
			message = "验证码错误";
			return Action.ERROR;
		}else{
			if(admin != null){
				if(password.equals(admin.getPassword())){
					ServletActionContext.getRequest().getSession().setAttribute("admin", admin);
					return Action.SUCCESS;
				}else{
					message = "用户名或密码错误";
					return Action.ERROR;
				}
			}else{
				message = "用户名或密码错误";
				return Action.ERROR;
			}
		}
	}

	/**
	 * 管理员退出
	 * @throws IOException
	 */
	public String exit(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("admin");
		return Action.SUCCESS;
	}
	
	public void code() throws IOException{
		String code = VerifyCodeUtils.generateVerifyCode(4);
		ServletActionContext.getRequest().getSession().setAttribute("code", code);
		BufferedImage image = VerifyCodeUtils.getImage(125, 40, code);
		ServletOutputStream os = ServletActionContext.getResponse().getOutputStream();
		ImageIO.write(image, "png", os);
		os.close();
	}
	
	
	
	
	
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public String getJudgeCode() {
		return judgeCode;
	}
	
	public void setJudgeCode(String judgeCode) {
		this.judgeCode = judgeCode;
	}
	
	
}








