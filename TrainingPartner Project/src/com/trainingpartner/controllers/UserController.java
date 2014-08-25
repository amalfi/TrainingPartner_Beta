package com.trainingpartner.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.trainingpartner.hibernate.HibernateUtil;
import com.trainingpartner.models.User;
import com.trainingpartner.tools.Tools;

public class UserController
{
	static Logger log = Logger.getLogger("com.trainingpartner.functions.database.DatabaseOperations");
	

	public static boolean SaveUser(String Username, String Password, String Description)
	{
		String sEncryptedPassword="";
		boolean bRegistration=false;
		log.debug("DatabaseOperations.InsertData");
		try
		{
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 
	        session.beginTransaction();
	        boolean bUserAlreadyExist = CheckIfUserAlreadyExistInDB(Username);
	        if(bUserAlreadyExist==false)
	        {
	        	log.debug("Uzytkownik o takim loginie nie istnieje jeszcze w systemie, zostanie utworzony");
	        	User user = new User();
	   		 
		        user.setLogin(Username);
		        
		        sEncryptedPassword=Tools.HashPassword(Password);
		        user.setPassword(sEncryptedPassword);
		        user.setUserDescription(Description);		        
		        
		        session.save(user);
		        session.getTransaction().commit();
		        
		        session.disconnect();	
		        bRegistration=true;
	        }
	        else
	        {
	        	log.debug("Uzytkownik o takim loginie istnieje juz w systemie, rejestracja zwroci blad");
	        	bRegistration=false;
	        }

	   }
	   catch(Exception e)
	   {
		   log.debug(e.getMessage());
		   e.printStackTrace();
	   }
		return bRegistration;
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
			log.debug("U퓓tkownika o takim loginie nie ma jeszcze w sytemie, zostanie zarejestrowany");
		}
		session.disconnect();
		return bUserExist;
	}
	public static boolean CheckLoginCreditentials(String sUsername, String sPassword)
	{
		boolean bCreditentialsAreOk=false;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Query query = session.createQuery("from User where login = :login and password = :password");
		query.setParameter("login", sUsername );
		query.setParameter("password", sPassword);
		 //jezeli lista jest pusta nie ma Usera o takim loginie w bazie i mozna rejestrowac
		List list = query.list();
		if(list.size()!=0)
		{
			log.debug("Podano poprawne dane u퓓tkownika");
			bCreditentialsAreOk=true;
		}
		
		if(bCreditentialsAreOk==false)
		{
			log.debug("Podano z쿮 dane u퓓tkownika");
		}
		session.disconnect();
		
		return bCreditentialsAreOk;
	}
}
