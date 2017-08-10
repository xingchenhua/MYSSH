package com.neusoft.action;

import com.neusoft.bean.User;
import com.neusoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private String username;
	private String password;

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

	@Override
	public String execute() throws Exception {
		// 保存用户的数据
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		// 调用业务逻辑层的userService接口来保存用户的数据
		userService.saveUser(user);
		return super.execute();
	}

}
