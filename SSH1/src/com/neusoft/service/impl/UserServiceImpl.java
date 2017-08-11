package com.neusoft.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.neusoft.bean.User;
import com.neusoft.dao.UserDao;
import com.neusoft.dao.page.Page;
import com.neusoft.service.UserService;

public class UserServiceImpl implements UserService {
	// ҵ���߼���������ݳ־ò�Ľӿ�
	private UserDao userDao;

	// �ṩһ��set��������ע��
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
		// �������ݳ־ò��findUserList����
		Page page = userDao.findUserList(currentPage, pageSize);
		return page;
	}

}
