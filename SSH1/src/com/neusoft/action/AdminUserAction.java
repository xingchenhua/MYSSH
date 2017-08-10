package com.neusoft.action;

import com.neusoft.dao.page.Page;
import com.neusoft.service.AdminUserService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserAction extends ActionSupport {
	// 需要调用业务逻辑层的接口
	private AdminUserService adminUserService;
	//当前的页
	private int currentPage=1;
	//每页显示的数量
	private int paseSize=5;
	private int totalPage;
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPaseSize() {
		return paseSize;
	}

	public void setPaseSize(int paseSize) {
		this.paseSize = paseSize;
	}
	
	//用来接收查找到的数据
	private  Page page;
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	// 提供set方法进行注入
	public AdminUserService getAdminUserService() {
		return adminUserService;
	}

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@Override
	public String execute() throws Exception {
		// 使用业务逻辑层的接口调用查找所有管理员的方法
		page = adminUserService.findAdminUserList(currentPage,paseSize);
		return SUCCESS;
	}

}
