package com.neusoft.service;

import java.util.List;

import com.neusoft.bean.AdminUser;
import com.neusoft.dao.page.Page;

public interface AdminUserService {
	public void saveAdminUser(AdminUser adminUser);

	public void updateAdminUser(AdminUser adminUser);

	public void deleteAdminUserById(int id);

	public Page findAdminUserList(int currentPage,int pageSize);
	
	
}
