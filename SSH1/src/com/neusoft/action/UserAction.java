package com.neusoft.action;

import java.util.List;

import com.neusoft.bean.User;
import com.neusoft.dao.page.Page;
import com.neusoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	//需要调用业务逻辑层的接口
	private UserService userService;
	//用来接收查找到的数据
	private List<User> data;
	private String username;
	private String password;
	private Page page;
	private int currentPage=1;
	private int pageSize=5;
	private int totalPage;
	//提供set方法进行注入
	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<User> getData() {
		return data;
	}
	public void setData(List<User> data) {
		this.data = data;
	}
	public UserService getUserService() {
		return userService;
	}
	@Override
	public String execute() throws Exception {
		//使用业务逻辑层的接口，调用查找所有管理员的方法
		page = userService.findUserList(currentPage,pageSize);
		return SUCCESS;
	}

}
