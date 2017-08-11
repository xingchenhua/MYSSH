package com.neusoft.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.neusoft.bean.AdminUser;
import com.neusoft.bean.User;
import com.neusoft.dao.UserDao;
import com.neusoft.dao.page.Page;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;
	// �ṩһ��set��������ע��
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//�õ�session�ķ���
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
		List<User> data1 = query.list();
		// ��0��ʼ���ܼ�¼+1
		query.setFirstResult((currentPage - 1) * pageSize);
		// ��1��ʼ��ֱ���ܼ�¼
		query.setMaxResults(pageSize);
		List<User> data2 = query.list();

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
