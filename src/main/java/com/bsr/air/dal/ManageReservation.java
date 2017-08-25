package com.bsr.air.dal;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bsr.air.domain.Reservation;

@SuppressWarnings("deprecation")
public class ManageReservation {
	private static SessionFactory factory;
	
	static {
		factory = new Configuration().configure().addResource("Reservation.hbm.xml").buildSessionFactory();
	}

	public static int postReservation(String s, int not, int fid, int uid, int tid) {
		Session session = factory.openSession();
		Integer rid = null;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Reservation r = new Reservation(s, not, fid, uid, tid);
			rid = (Integer) session.save(r);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return rid;
	}

	@SuppressWarnings("unchecked")
	public static String getReservationcode(int uid, int tid) {
		Session session = factory.openSession();
		List<Reservation> list = null;
		list = (List<Reservation>) session.createQuery("FROM Reservation where upid=" + uid + " and transid=" + tid)
				.list();
		session.close();
		return list.get(0).getConfnbr();
	}
    
	@SuppressWarnings("unchecked")
	public static Reservation getReservation(String confnbr) {
		Session session = factory.openSession();
		List<Reservation> list = null;
		list = (List<Reservation>) session.createQuery("FROM Reservation where confnbr='" + confnbr + "'")
				.list();
		session.close();
		return list.get(0);
	}
}