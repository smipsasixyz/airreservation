package com.bsr.air.dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bsr.air.domain.LoginTable;
import com.bsr.air.domain.User;

public class ManageUser {
   private static SessionFactory factory; 
   static {
	   factory = new Configuration().configure().addResource("LoginTable.hbm.xml").addResource("User.hbm.xml").buildSessionFactory();
   }
   

   
   @SuppressWarnings("unchecked")
public static boolean insertlog( String e,String p) throws SQLException {
	      Session session = factory.openSession();
	      List<LoginTable> users = new ArrayList<LoginTable>();

			users = session
				.createQuery("from LoginTable where email=? and password=?")
				.setParameter(0, e)
				.setParameter(1, p)
				.list();

			if (users.size() > 0) {
				return true;
			} else {
				return false;
			}
   }
   
   @SuppressWarnings("unchecked")
public static int getUser( String e) throws SQLException {
	      Session session = factory.openSession();
	      List<User> list = null;
	         list = (List<User>)session.createQuery("FROM User where email=?").setParameter(0, e)
	 				.list(); 
				return list.get(0).getUid();
			
}
   @SuppressWarnings("unchecked")
   public static User getUserByID( int uid) throws SQLException {
   	      Session session = factory.openSession();
   	      List<User> list = null;
   	         list = (List<User>)session.createQuery("FROM User where upid=?").setParameter(0, uid)
   	 				.list(); 
   				return list.get(0);
   			
   }
   

}