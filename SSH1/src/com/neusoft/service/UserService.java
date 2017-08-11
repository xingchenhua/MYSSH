package com.neusoft.service;

import java.util.List;

import com.neusoft.bean.User;
import com.neusoft.dao.page.Page;

public interface UserService {
	public void saveUser(User user);
	public void updateUser(User user);
	public void deteleUserById(User user);
	public	Page findUserList(int currentPage,int pageSize);
}
