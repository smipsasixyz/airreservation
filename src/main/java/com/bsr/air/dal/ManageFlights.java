package com.bsr.air.dal;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bsr.air.domain.Flight;

public class ManageFlights {
   private static SessionFactory factory; 
   static {
	   factory = new Configuration().configure().buildSessionFactory();
   }
   

@SuppressWarnings("unchecked")
public static List<Flight> listFlights(String ori,String des ){
      Session session = factory.openSession();
      List<Flight> list = null;
         list = (List<Flight>)session.createQuery("FROM Flight where origin='"+ori+"' and destination='"+des+"'").list(); 
         session.close();
         return list;
      }
   
   public static Flight getFlight(int fid ){
	      Session session = factory.openSession();
          Flight f=(Flight) session.get(Flight.class, fid);
          session.close();
          return f;
   }
   
   public static boolean updateFlight(int fid,int not){
	   Session session = factory.openSession();
       Transaction tx = null;
       boolean result=false;
	   try{
		   Flight f=(Flight) session.get(Flight.class, fid);
	       f.setNseats(f.getNseats()-not);
		   tx = session.beginTransaction();
	      session.save(f); 
	      tx.commit();
	      result=true;
	   }catch (HibernateException e) {
	      if (tx!=null) tx.rollback();
	      e.printStackTrace(); 
	   }finally {
	      session.close(); 
	   }     
	   return result;
}
}