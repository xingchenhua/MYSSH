package com.neusoft.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.neusoft.bean.User;

public class CreateTable {

	public static void main(String[] args) {
		// ����Configuration����
		Configuration cfg = new Configuration();
		// �������ļ�
		cfg.configure();
		// ͨ��Configuration��������SchemaExport����
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}

}
