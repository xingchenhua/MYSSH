package com.neusoft.service.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.bean.User;
import com.neusoft.dao.UserDao;
import com.neusoft.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		if (null == user) {
			System.out.println("user is null");
		} else {
			userDao.saveUser(user);
		}
	}

}
