package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.assignt;

public class assigntDao {
	
	SessionFactory factory = new Configuration().configure().addAnnotatedClass(assignt.class).buildSessionFactory();

	public void teacherclass(assignt t) {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		System.out.println("insert successfully");
	}


}
