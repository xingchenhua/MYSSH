package com.neusoft.service.impl;

import java.util.List;

import com.neusoft.bean.AdminUser;
import com.neusoft.dao.AdminUserDao;
import com.neusoft.dao.page.Page;
import com.neusoft.service.AdminUserService;

public class AdminUserServiceImpl implements AdminUserService {
	// ҵ���߼���������ݳ־ò�Ľӿ�
	private AdminUserDao adminUserDao;
	// �ṩһ��set��������ע��
	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	@Override
	public void saveAdminUser(AdminUser adminUser) {
		adminUserDao.saveAdminUser(adminUser);
	}

	@Override
	public void updateAdminUser(AdminUser adminUser) {
		adminUserDao.updateAdminUser(adminUser);

	}

	@Override
	public void deleteAdminUserById(AdminUser adminUser) {
		adminUserDao.deleteAdminUserById(adminUser);

	}

	@Override
	public Page findAdminUserList(int currentPage,int pageSize){
		// �������ݳ־ò��findAdminUserList����
		Page page = adminUserDao.findAdminUserList(currentPage,pageSize);
		return page;
	}

	@Override
	public AdminUser findAdminUserById(int id) {
		AdminUser admin = adminUserDao.findAdminById(id);
		return admin;
	}

}
