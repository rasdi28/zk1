package com.sdd.zk1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sdd.zk1.domain.Mproduct;


public class ProductDAO {

	SessionFactory sesionFactory = new Configuration().configure().buildSessionFactory();
	Session session;
	
	@SuppressWarnings("unchecked")
	public List<Mproduct> listAll() {
		List<Mproduct> objList = null;
		session = sesionFactory.openSession();
		objList = session.createQuery("from Mproduct").list();
		session.close();
		return objList;
	}
}
