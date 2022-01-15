package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Subjects;

public class SubjectsDao {

	SessionFactory factory = new Configuration().configure().addAnnotatedClass(Subjects.class).buildSessionFactory();

	public List<Subjects> listsubjects() {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Subjects> subjects = session.createQuery("from subjects").list();
		// session.getTransaction().commit();
		return subjects;
}
}
