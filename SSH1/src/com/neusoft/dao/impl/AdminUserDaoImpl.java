package com.neusoft.dao.impl;

import java.util.List;

import javax.persistence.criteria.From;
import javax.xml.crypto.Data;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.neusoft.bean.AdminUser;
import com.neusoft.dao.AdminUserDao;
import com.neusoft.dao.page.Page;

public class AdminUserDaoImpl implements AdminUserDao {
	private SessionFactory sessionFactory;

	// 提供一个set方法进行注入
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 得到session的方法
	public Session getsSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public void saveAdminUser(AdminUser adminUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAdminUser(AdminUser adminUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAdminUserById(int id) {
	

	}

	@Override
	public Page findAdminUserList(int currentPage,int pageSize) {
		Query query = getsSession().createQuery("from AdminUser");
		List<AdminUser> data1 = query.list();
		//总0开始，总记录+1
		query.setFirstResult((currentPage-1)*pageSize);
		//总1开始，直接总记录
		query.setMaxResults(pageSize);
		List<AdminUser> data2 = query.list();
		
		Page page = new Page(data2);
		page.setAllRow(data1.size());
		page.setPageSize(pageSize);
		page.setTotalPage();
		page.setCurrentPage(currentPage);
		page.isHasNextPage();
		page.isHasPrePage();
		return page;
		}
}
