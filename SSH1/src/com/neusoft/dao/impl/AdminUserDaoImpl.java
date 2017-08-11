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
	// �ṩһ��set��������ע��
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// �õ�session�ķ���
	public Session getsSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public void saveAdminUser(AdminUser adminUser) {
		getsSession().save(adminUser);
	}

	@Override
	public void updateAdminUser(AdminUser adminUser) {
		getsSession().update(adminUser);

	}

	@Override
	public void deleteAdminUserById(AdminUser adminUser) {
		getsSession().delete(adminUser);
	}

	@Override
	public Page findAdminUserList(int currentPage, int pageSize) {
		Query query = getsSession().createQuery("from AdminUser");
		List<AdminUser> data1 = query.list();
		// ��0��ʼ���ܼ�¼+1
		query.setFirstResult((currentPage - 1) * pageSize);
		// ��1��ʼ��ֱ���ܼ�¼
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

	@Override
	public AdminUser findAdminById(int id) {
		Query query = getsSession().createQuery(
				"from AdminUser a where a.id=" + id);
		AdminUser admin = (AdminUser)query.list().get(0);
		return admin;
	}
}
