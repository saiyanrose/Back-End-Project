package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.assigncs;

public class assigncsDao {

	SessionFactory factory = new Configuration().configure().addAnnotatedClass(assigncs.class).buildSessionFactory();

	public void subjectclass(assigncs cs) {

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(cs);
		session.getTransaction().commit();
		System.out.println("insert successfully");
	}

}
