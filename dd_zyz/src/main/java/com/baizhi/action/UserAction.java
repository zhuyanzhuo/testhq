package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Book;
import com.baizhi.entity.User;
import com.baizhi.service.impl.UserServiceImpl;
import com.baizhi.util.MD5Utils;
import com.baizhi.util.SendEmailUtil;
import com.baizhi.util.VerifyCodeUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private String email;
	private String password;
	private String message;
	private User user;
	private String inputCode;
	private String id;
	private List<Book> books;

	/**
	 * 前台用户登陆
	 * @return
	 */
	public String login(){
		UserServiceImpl impl = new UserServiceImpl();
		User user = impl.loginService(email);
		if(user != null){
			if(user.getPassword().equals(MD5Utils.getPassword(password + user.getSalt()))){
				if(user.getStatus().equals("正常")){
					ServletActionContext.getRequest().getSession().setAttribute("user", user);
					return Action.SUCCESS;
				}else{
					message="账户被冻结";
					return Action.ERROR;
				}
			}else{
				message = "邮箱或者密码错误";
				return Action.ERROR;
			}
		}else{
			message = "邮箱或者密码错误";
			return Action.ERROR;
		}
	}

	/**
	 * 前台用户注册
	 * @return
	 */
	public String register(){
		UserServiceImpl impl = new UserServiceImpl();
		String userCode = (String) ServletActionContext.getRequest().getSession().getAttribute("userCode");
		if(userCode.equalsIgnoreCase(inputCode)){
			User checkUser = impl.findOneByEmailService(user.getEmail());
			if(checkUser != null){
				message="该用户已被注册";
				return Action.ERROR;
			}else{
				user.setId(UUID.randomUUID().toString());
				user.setStatus("正常");
				String salt = MD5Utils.getSalt();
				user.setSalt(salt);
				String password = MD5Utils.getPassword(user.getPassword() + salt);
				user.setPassword(password);
				user.setKey("");
				impl.registerService(user);
				ServletActionContext.getRequest().getSession().setAttribute("user", user);
				return Action.SUCCESS;
			}
		}else{
			message="验证码错误";
			return Action.ERROR;
		}
	}
	
	/**
	 * 前台用户注册完成，创建一个邮箱验证码发送至激活用户界面用于验证用户激活
	 */
	public String sendEmail(){
		String salt = MD5Utils.getSalt();
		user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		ServletActionContext.getRequest().getSession().setAttribute("emailCode", salt);
		SendEmailUtil.sendMessage(user.getEmail(), salt);
		return Action.SUCCESS;
	}
	
	/**
	 * 用户激活
	 */
	public String active(){
		UserServiceImpl impl = new UserServiceImpl();
		String emailCode = (String) ServletActionContext.getRequest().getSession().getAttribute("emailCode");
		if(emailCode.equalsIgnoreCase(inputCode)){
			user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
			user.setKey(emailCode);
			impl.updateKeyService(user);
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return Action.SUCCESS;
		}else{
			message="邮箱验证码错误";
			return Action.ERROR;
		}
	}
	
	/**
	 * 前台用户退出
	 */
	public String exit(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.invalidate();
		return Action.SUCCESS;
	}
	
	/**
	 * 前台用户注册验证码
	 * @throws Exception
	 */
	public void userCode() throws Exception{
		String userCode = VerifyCodeUtils.generateVerifyCode(4);
		ServletActionContext.getRequest().getSession().setAttribute("userCode", userCode);
		BufferedImage image = VerifyCodeUtils.getImage(125, 40, userCode);
		ServletOutputStream os = ServletActionContext.getResponse().getOutputStream();
		ImageIO.write(image, "png", os);
		os.close();
	}

	/**
	 * 通过登陆用户的id查找其名下的所有图书
	 * @return
	 */
	public String findAllBook(){
		UserServiceImpl impl = new UserServiceImpl();
		User u = impl.findAllBookByUser(id);
		books = u.getBooks();
		return Action.SUCCESS;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}
	
}













