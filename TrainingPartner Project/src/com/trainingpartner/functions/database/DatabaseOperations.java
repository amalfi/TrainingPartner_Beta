package com.trainingpartner.functions.database;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.trainingpartner.hibernate.HibernateUtil;
import com.trainingpartner.models.User;

public class DatabaseOperations 
{
	static Logger log = Logger.getLogger("com.trainingpartner.functions.database.DatabaseOperations");
	
	public static void SaveUser(String Username, String Password, String Description)
	{
		log.debug("DatabaseOperations.InsertData");
		try
		{
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 
	        session.beginTransaction();
	        boolean bUserAlreadyExist = CheckIfUserAlreadyExistInDB(Username);
	        
	        User user = new User();
	 
	        user.setLogin(Username);
	        user.setPassword(Password);
	        user.setUserDescription(Description);
	        
	        
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
	
	public static boolean CheckIfUserAlreadyExistInDB(String Username)
	{
		boolean bUserExist=false;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		 
		Query query = session.createQuery("from User where login = :login ");
		query.setParameter("login", Username );
		 //jezeli lista jest pusta nie ma Usera o takim loginie w bazie i mozna rejestrowac
		List list = query.list();
		if(list.size()!=0)
		{
			for(int i=0; i<list.size(); i++)
			{
				String CucrrentElement = String.valueOf(list.get(i));
			}
			log.debug("Uzytkownik o takim loginie istnieje juz w systemie");
		}
		
		if(bUserExist==false)
		{
			log.debug("U¿ytkownika o takim loginie nie ma jeszcze w sytemie, zostanie zarejestrowany");
		}
		session.disconnect();
		return bUserExist;
	}
	public static void GetData()
	{

	}
}
