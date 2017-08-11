package com.neusoft.dao;

import com.neusoft.bean.User;
import com.neusoft.dao.page.Page;

public interface UserDao {
	public void saveUser(User user);
	public void updateUser(User user);
	public void deteleUserById(User user);
	public	Page findUserList(int currentPage,int pageSize);
}
