package com.bsr.air.dal;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bsr.air.domain.TransactionUser;
import com.bsr.air.domain.User;

public class ManageTransactionUser {
	private static SessionFactory factory;
	static {
		factory = new Configuration().configure().addResource("TransactionUser.hbm.xml").buildSessionFactory();
	}

	@SuppressWarnings("unchecked")
	public static int postTransaction(int uid, double amount) {
		Session session = factory.openSession();
		Date utildate = new Date();
		java.sql.Date sqlDate = new java.sql.Date(utildate.getTime());
		String status = "booked";
		Integer tid = null;
		Transaction tx = null;
		boolean b = false;
		try {
			tx = session.beginTransaction();
			TransactionUser t = new TransactionUser(uid, amount, sqlDate, status);
			tid = (Integer) session.save(t);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return tid;
	}
	

	public static boolean changeStatus(int tid) throws SQLException {
		Session session = factory.openSession();
		String status = "cancled";
		boolean result = false;
		try {
			session.beginTransaction();
			TransactionUser t = (TransactionUser)session.get(TransactionUser.class, tid);	
			t.setTransmsg(status);
		    session.getTransaction().commit();
			result=true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	

	@SuppressWarnings("unchecked")
	public static TransactionUser getTransactionUserByID(int tid) throws SQLException {
		Session session = factory.openSession();
		List<TransactionUser> list = null;
		list = (List<TransactionUser>) session.createQuery("FROM TransactionUser where transid=?").setParameter(0, tid)
				.list();
		return list.get(0);

	}

}