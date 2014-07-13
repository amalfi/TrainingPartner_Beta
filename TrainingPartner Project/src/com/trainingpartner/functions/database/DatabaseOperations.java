package com.trainingpartner.functions.database;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.trainingpartner.hibernate.HibernateUtil;
import com.trainingpartner.models.User;

public class DatabaseOperations 
{
	static Logger log = Logger.getLogger("com.trainingpartner.functions.database.DatabaseOperations");
	
	public static void InsertData()
	{
		log.debug("DatabaseOperations.InsertData");
		try
		{
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 
	        session.beginTransaction();
	        User user = new User();
	 
	        user.setUserId(1);
	        user.setLogin("admin");
	        user.setPassword("haslo");
	        user.setUserDescription("so");
	        
	        
	        session.save(user);
	        session.getTransaction().commit();
	        
	        session.disconnect();
		}
	   catch(Exception e)
	   {
		   log.debug(e.getMessage());
		   e.printStackTrace();
	   }
	}
	
	public static void GetData()
	{

	}
}
