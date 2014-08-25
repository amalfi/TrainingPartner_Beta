package com.trainingpartner.controllers;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.trainingpartner.hibernate.HibernateUtil;
import com.trainingpartner.models.TrainingDiary;
import com.trainingpartner.models.TrainingSchedule;

public class TrainingScheduleController 
{
	static Logger log = Logger.getLogger("com.trainingpartner.controllers.TrainingScheduleController");
	
	public static boolean SaveTrainingSchedule(HashMap<String,String> TrainingScheduleMap, String sTrainingScheduleName)
	{
		boolean bSuccess=false;

		log.debug("Saving Training Schedule");
		try
		{
		 Session session = HibernateUtil.getSessionFactory().openSession();
		 
	        session.beginTransaction();
	        boolean bTrainingScheduleAlreadyExist = CheckIfTrainingScheduleAlreadyExistInDB(sTrainingScheduleName);
	        if(bTrainingScheduleAlreadyExist==false)
	        {
	        	log.debug("Uzytkownik o takim loginie nie istnieje jeszcze w systemie, zostanie utworzony");
	        	TrainingSchedule ts = new TrainingSchedule();        
		        //-------------------------------------
	        	ts.setTrainingScheduleDescription(TrainingScheduleMap.get(""));
	        	ts.setTrainingScheduleExcersisesNumber(Long.valueOf(TrainingScheduleMap.get("")));
	        	ts.setTrainingScheduleName(TrainingScheduleMap.get(""));
	        	//------------------------------------
		        session.save(ts);
		        session.getTransaction().commit();
		        
		        session.disconnect();	
		        bSuccess=true;
	        }
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
	
	public static boolean CheckIfTrainingScheduleAlreadyExistInDB(String TrainingScheduleName)
	{
		boolean bUserExist=false;
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		 
		Query query = session.createQuery("from TrainingSchedule where trainingSchedule = :trainingSchedule ");
		query.setParameter("trainingSchedule", TrainingScheduleName );
		 //jezeli lista jest pusta nie ma Usera o takim loginie w bazie i mozna rejestrowac
		List list = query.list();
		if(list.size()!=0)
		{
			for(int i=0; i<list.size(); i++)
			{
				String CucrrentElement = String.valueOf(list.get(i));
			}
			log.debug("Program treningowy o takiej nazwie istnieje juz w bazie danych");
		}
		
		if(bUserExist==false)
		{
			log.debug("Program treningowy o takiej nazwie nie istnieje jeszcze w bazie danych i zostanie zapisany");
		}
		session.disconnect();
		return bUserExist;
	
	}
}
