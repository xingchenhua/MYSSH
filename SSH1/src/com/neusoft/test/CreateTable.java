package com.neusoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.neusoft.bean.User;

public class CreateTable {

	public static void main(String[] args) {
		// 生成Configuration对象
		Configuration cfg = new Configuration();
		// 读配置文件
		cfg.configure();
		// 通过Configuration对象生成SchemaExport对象
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}

}
