package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Students;


public class StudentsDao {

	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Students.class).buildSessionFactory();

	public List<Students> liststudents() {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Students> students = session.createQuery("from students").list();
		// session.getTransaction().commit();
		return students;
	}
}
