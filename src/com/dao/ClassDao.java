package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.entity.listofclass;

public class ClassDao {

	SessionFactory factory = new Configuration().configure().addAnnotatedClass(listofclass.class).buildSessionFactory();

	public List<listofclass> listclass() {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<listofclass>classess = session.createQuery("from class").list();
		// session.getTransaction().commit();
		return classess;

	}
}
