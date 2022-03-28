package com.sdd.zk1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sdd.zk1.domain.Mdepartement;


public class MdepartementDAO {

	// konfigurasi hibernate
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session;
	
	@SuppressWarnings("unchecked")
	public List<Mdepartement> listAll(String orderby){
		List<Mdepartement> objList = null;
		session = sessionFactory.openSession();
		objList = session.createQuery("from Mdepartement order by " + orderby + " asc").list();
		session.close();
		return objList;		
	}

	public void save(Mdepartement objDepatement) {
		session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.saveOrUpdate(objDepatement);
		trx.commit();
		session.close();
	}
	
	public void delete(Mdepartement objEmployee) {
		session = sessionFactory.openSession();
		Transaction trx = session.beginTransaction();
		session.delete(objEmployee);
		trx.commit();
		session.close();
	}

	//tambahan
	@SuppressWarnings("unchecked")
	public List<Mdepartement> listAll(){
		List<Mdepartement> objList = null;
		session = sessionFactory.openSession();
		objList = session.createQuery("from Mdepartement ").list();
		session.close();
		return objList;		
	}
	
}
