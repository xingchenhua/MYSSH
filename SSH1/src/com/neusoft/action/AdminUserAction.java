package com.neusoft.action;

import org.hibernate.validator.constraints.Length;

import com.neusoft.bean.AdminUser;
import com.neusoft.dao.page.Page;
import com.neusoft.service.AdminUserService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserAction extends ActionSupport {
	// 需要调用业务逻辑层的接口
	private AdminUserService adminUserService;
	private int id;
	private String username;
	private String password;
	//定义数组执行删除全部
	private int[] ids;
	//当前的页
	private int currentPage=1;
	//每页显示的数量
	private int paseSize=5;
	private int totalPage;
	//用来接收查找到的数据
	private  Page page;
	private AdminUser adminUser;
	
	public AdminUser getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(AdminUser adminUser) {
		this.adminUser = adminUser;
	}

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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
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
	
	//注册的方法
	public String register(){
		AdminUser adminUser = new AdminUser();
		adminUser.setUsername(username);
		adminUser.setPassword(password);
		adminUserService.saveAdminUser(adminUser);
		return SUCCESS;
	}
	//通过id查找管理的方法
	public String findAdminById(){
		adminUser = adminUserService.findAdminUserById(id);
		return "updatetopage";
	}
	//修改
	public String updateAdmin(){
		 AdminUser adminUser = new AdminUser();
		 adminUser.setId(id);
		 adminUser.setUsername(username);
		 adminUser.setPassword(password);
		adminUserService.updateAdminUser(adminUser);
		return SUCCESS;
	}
	//删除
	public String deleteAdminById(){
		adminUser = adminUserService.findAdminUserById(id);
		adminUserService.deleteAdminUserById(adminUser);
		return SUCCESS; 
	}
	
	
	//删除全部
	public String deleteAdmins(){
		if(ids!=null && ids.length>0){
			for (int i = 1; i < ids.length; i++) {
				adminUser = adminUserService.findAdminUserById(id);
				adminUserService.deleteAdminUserById(adminUser);
				
			}
		}
		return SUCCESS;	
	}
}
