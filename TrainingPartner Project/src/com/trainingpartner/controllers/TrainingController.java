package com.trainingpartner.controllers;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.trainingpartner.hibernate.HibernateUtil;
import com.trainingpartner.models.Training;


public class TrainingController 
{
	static Logger log = Logger.getLogger("com.trainingpartner.controllers.TrainingController");
	

	public static boolean SaveTraining(HashMap<String,String> TrainingMap)
	{
		boolean bSuccess=false;
		log.debug("Saving Training");
		try
		{
		 Session session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        
	        	Training t = new Training();        
		        //-------------------------------------
	        	t.setTrainingDescription(TrainingMap.get("trainingDescription"));
	        	t.setTrainingDiary(TrainingMap.get(""));
	        	t.setTrainingExcersises(TrainingMap.get(""));
	        	t.setTrainingSchedule(TrainingMap.get(""));
	        	//------------------------------------
		        session.save(t);
		        session.getTransaction().commit();
		        
		        session.disconnect();	
		        bSuccess=true;

	   }
	   catch(Exception e)
	   {
		   log.debug(e.getMessage());
		   e.printStackTrace();
	   }

		
		return bSuccess;
	}

	
}
