package com.neusoft.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.neusoft.bean.User;
import com.neusoft.service.UserService;

public class Test {

	public static void main(String[] args) {
		// 如果运行在WEB服务中，不需要前两行代码
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		SessionFactory sf = ctx.getBean("sessionFactory", SessionFactory.class);
		sf.openSession();

		UserService us = ctx.getBean("userService", UserService.class);

		// 生成一个User对象
		User user = new User();
		user.setUsername("bbb");
		user.setPassword("444");
		us.saveUser(user);
	}

}
