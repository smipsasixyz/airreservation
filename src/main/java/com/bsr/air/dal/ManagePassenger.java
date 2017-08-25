package com.bsr.air.dal;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bsr.air.domain.Passenger;
import com.bsr.air.domain.Reservation;

public class ManagePassenger {
   private static SessionFactory factory; 
   static {
	   factory = new Configuration().configure().addResource("Passenger.hbm.xml").buildSessionFactory();
   }
   
   public static void addPassengers(List<Passenger> p,int rid){
      for(Passenger x:p)
      {
    	  addPassenger(x,rid);
      }
   }
   
   public static void deletePassengers(List<Passenger> p){
	      for(Passenger x:p)
	      {
	    	  deletePassenger(x);
	      }
	   }
   
   public static  void addPassenger(Passenger p,int rid){
	   Session session = factory.openSession();
	   Transaction tx = null;
	   try{
	      tx = session.beginTransaction();
	      p.setRid(rid);
	      session.save(p); 
	      tx.commit();
	   }catch (HibernateException e) {
	      if (tx!=null) tx.rollback();
	      e.printStackTrace(); 
	   }finally {
	      session.close(); 
	   }     
   }
   public static  void deletePassenger(Passenger p){
	   Session session = factory.openSession();
	   Transaction tx = null;
	   try{
	      tx = session.beginTransaction();
	      session.delete(p); 
	      tx.commit();
	   }catch (HibernateException e) {
	      if (tx!=null) tx.rollback();
	      e.printStackTrace(); 
	   }finally {
	      session.close(); 
	   }     
   }
   @SuppressWarnings("unchecked")
   public static List<Passenger> getPassengers(int rid){
	   Session session = factory.openSession();
		List<Passenger> list = null;
		list = (List<Passenger>) session.createQuery("FROM Passenger where rid=" + rid)
				.list();
		session.close();
		return list;
	   }
   
 
}