package com.neusoft.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.neusoft.bean.User;
import com.neusoft.dao.UserDao;
import com.neusoft.dao.page.Page;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;
	// 提供一个set方法进行注入
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//得到session的方法
	public Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public void saveUser(User user) {
		getSession().save(user);
	}

	@Override
	public void updateUser(User user) {
		getSession().update(user);
		
	}

	@Override
	public void deteleUserById(User user) {
		getSession().delete(user);
	}

	@Override
	public Page findUserList(int currentPage,int pageSize) {
		Query query = getSession().createQuery("from User");
		query.setFirstResult((currentPage-1)*pageSize);
		query.setMaxResults(pageSize);
		List<User> data = query.list();
		Page page = new Page(data);
		page.setAllRow();
		page.setPageSize(pageSize);
		page.setTotalPage();
		page.setCurrentPage(currentPage);
		return page;
	}

}
