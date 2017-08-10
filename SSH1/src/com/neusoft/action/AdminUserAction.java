package com.neusoft.action;

import com.neusoft.dao.page.Page;
import com.neusoft.service.AdminUserService;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserAction extends ActionSupport {
	// ��Ҫ����ҵ���߼���Ľӿ�
	private AdminUserService adminUserService;
	//��ǰ��ҳ
	private int currentPage=1;
	//ÿҳ��ʾ������
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
	
	//�������ղ��ҵ�������
	private  Page page;
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

}
