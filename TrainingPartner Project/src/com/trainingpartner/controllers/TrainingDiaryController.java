package com.trainingpartner.controllers;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.trainingpartner.hibernate.HibernateUtil;
import com.trainingpartner.models.TrainingDiary;

public class TrainingDiaryController 
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
	        boolean bDiaryAlreadyExist = CheckIfDiaryAlreadyExistInDB(sDiaryName);
	        if(bDiaryAlreadyExist==false)
	        {
	        	log.debug("");
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
	        	log.debug("Dziennik treningowy o takiej nazwie juz istnieje");
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
}
