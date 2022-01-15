package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.assigncs;
import com.entity.assignsc;

public class assignscDao {

	SessionFactory factory = new Configuration().configure().addAnnotatedClass(assignsc.class).buildSessionFactory();

	public void studentclass(assignsc sc) {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(sc);
		session.getTransaction().commit();
		System.out.println("insert successfully");
	}
	
}
