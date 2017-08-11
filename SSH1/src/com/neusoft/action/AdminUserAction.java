package com.neusoft.action;

import org.hibernate.validator.constraints.Length;

import com.neusoft.bean.AdminUser;
import com.neusoft.dao.page.Page;
import com.neusoft.service.AdminUserService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserAction extends ActionSupport {
	// ��Ҫ����ҵ���߼���Ľӿ�
	private AdminUserService adminUserService;
	private int id;
	private String username;
	private String password;
	//��������ִ��ɾ��ȫ��
	private int[] ids;
	//��ǰ��ҳ
	private int currentPage=1;
	//ÿҳ��ʾ������
	private int paseSize=5;
	private int totalPage;
	//�������ղ��ҵ�������
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
	// �ṩset��������ע��
	public AdminUserService getAdminUserService() {
		return adminUserService;
	}

	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	@Override
	public String execute() throws Exception {
		// ʹ��ҵ���߼���Ľӿڵ��ò������й���Ա�ķ���
		page = adminUserService.findAdminUserList(currentPage,paseSize);
		return SUCCESS;
	}
	
	//ע��ķ���
	public String register(){
		AdminUser adminUser = new AdminUser();
		adminUser.setUsername(username);
		adminUser.setPassword(password);
		adminUserService.saveAdminUser(adminUser);
		return SUCCESS;
	}
	//ͨ��id���ҹ���ķ���
	public String findAdminById(){
		adminUser = adminUserService.findAdminUserById(id);
		return "updatetopage";
	}
	//�޸�
	public String updateAdmin(){
		 AdminUser adminUser = new AdminUser();
		 adminUser.setId(id);
		 adminUser.setUsername(username);
		 adminUser.setPassword(password);
		adminUserService.updateAdminUser(adminUser);
		return SUCCESS;
	}
	//ɾ��
	public String deleteAdminById(){
		adminUser = adminUserService.findAdminUserById(id);
		adminUserService.deleteAdminUserById(adminUser);
		return SUCCESS; 
	}
	
	
	//ɾ��ȫ��
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
