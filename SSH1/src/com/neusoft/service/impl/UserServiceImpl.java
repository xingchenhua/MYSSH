package com.neusoft.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.bean.User;
import com.neusoft.dao.UserDao;
import com.neusoft.dao.page.Page;
import com.neusoft.service.UserService;

public class UserServiceImpl implements UserService {
	// 业务逻辑层调用数据持久层的接口
	private UserDao userDao;

	// 提供一个set方法进行注入
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);

	}

	@Override
	public void deteleUserById(User user) {
		userDao.deteleUserById(user);

	}

	@Override
	public Page findUserList(int currentPage, int pageSize) {
		// 调用数据持久层的findUserList方法
		Page page = userDao.findUserList(currentPage, pageSize);
		return page;
	}

}
