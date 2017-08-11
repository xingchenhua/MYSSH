package com.neusoft.dao;

import com.neusoft.bean.AdminUser;
import com.neusoft.dao.page.Page;

public interface AdminUserDao {
	public void saveAdminUser(AdminUser adminUser);
	public void updateAdminUser(AdminUser adminUser);
	public void deleteAdminUserById(AdminUser adminUser);
	public Page findAdminUserList(int currentPage,int pageSize);
	public AdminUser findAdminById(int id);

}
