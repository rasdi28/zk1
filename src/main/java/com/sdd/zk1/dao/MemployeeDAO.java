package com.sdd.zk1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sdd.zk1.domain.Memployee;



public class MemployeeDAO {

	// konfigurasi hibernate
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session;
	
	@SuppressWarnings("unchecked")
	public List<Memployee> listAll(String orderby){
		List<Memployee> objList = null;
		session = sessionFactory.openSession();
		objList = session.createQuery("from Memployee order by " + orderby + " asc").list();
		session.close();
		return objList;		
	}

	public void save(Memployee objEmployee) {
		session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(objEmployee);
		trx.commit();
		session.close();
	}
	
	public void delete(Memployee objEmployee) {
		Session session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.delete(objEmployee);
		trx.commit();
		session.close();
	}
	
	

	
	
}
