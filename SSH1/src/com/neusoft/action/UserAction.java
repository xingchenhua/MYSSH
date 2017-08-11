package com.neusoft.action;

import java.util.List;

import com.neusoft.bean.User;
import com.neusoft.dao.page.Page;
import com.neusoft.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	//��Ҫ����ҵ���߼���Ľӿ�
	private UserService userService;
	//�������ղ��ҵ�������
	private List<User> data;
	private String username;
	private String password;
	private Page page;
	private int currentPage=1;
	private int pageSize=5;
	private int totalPage;
	//�ṩset��������ע��
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
		//ʹ��ҵ���߼���Ľӿڣ����ò������й���Ա�ķ���
		page = userService.findUserList(currentPage,pageSize);
		return SUCCESS;
	}

}
