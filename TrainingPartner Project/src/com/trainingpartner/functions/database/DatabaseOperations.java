package com.trainingpartner.functions.database;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.trainingpartner.hibernate.HibernateUtil;
import com.trainingpartner.models.TrainingDiary;
import com.trainingpartner.models.User;
import com.trainingpartner.tools.Tools;

public class DatabaseOperations 
{
	static Logger log = Logger.getLogger("com.trainingpartner.functions.database.DatabaseOperations");
	
	public static boolean SaveDiary(HashMap<String,String> DiaryMap, String sDiaryName)
	{
		boolean bSuccess=false;
		
		log.debug("DatabaseOperations.SaveDiary");
		try
		{
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 
	        session.beginTransaction();
	        boolean bUserAlreadyExist = CheckIfDiaryAlreadyExistInDB(sDiaryName);
	        if(bUserAlreadyExist==false)
	        {
	        	log.debug("Uzytkownik o takim loginie nie istnieje jeszcze w systemie, zostanie utworzony");
	        	TrainingDiary td = new TrainingDiary();        
		        //-------------------------------------
	        	////{diaryCreator=null, diaryCreationDate=08/21/2014, diaryDescription=test, trainingProgram=null, diaryName=Test}
	        	td.setDiaryCreationDate(DiaryMap.get("diaryCreationDate"));
	        	td.setDiaryName(DiaryMap.get("diaryName"));
	        	td.setDiaryDescription(DiaryMap.get("diaryDescription"));
	        	td.setDiaryCreator(DiaryMap.get("diaryCreator"));
	        	//------------------------------------
		        session.save(td);
		        session.getTransaction().commit();
		        
		        session.disconnect();	
		        bSuccess=true;
	        }
	        else
	        {
	        	log.debug("Dziennik o takiej nazwie juz istnieje");
	        	bSuccess=false;
	        }

	   }
	   catch(Exception e)
	   {
		   log.debug(e.getMessage());
		   e.printStackTrace();
	   }
		
		return bSuccess;
	}
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
	
	public static boolean CheckIfDiaryAlreadyExistInDB(String DiaryName)
	{
		boolean bUserExist=false;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		 
		Query query = session.createQuery("from TrainingDiary where diaryName = :diaryName ");
		query.setParameter("diaryName", DiaryName );
		 //jezeli lista jest pusta nie ma Usera o takim loginie w bazie i mozna rejestrowac
		List list = query.list();
		if(list.size()!=0)
		{
			for(int i=0; i<list.size(); i++)
			{
				String CucrrentElement = String.valueOf(list.get(i));
			}
			log.debug("Dziennik o takiej nazwie istnieje juz w systemie , nie zostanie zarejestrowany");
		}
		
		if(bUserExist==false)
		{
			log.debug("Dziennika o takiej nazwie nie ma jeszcze w systemie, zostanie zarejestrowany");
		}
		session.disconnect();
		return bUserExist;
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
