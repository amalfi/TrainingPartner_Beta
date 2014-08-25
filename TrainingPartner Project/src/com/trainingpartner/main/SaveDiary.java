package com.trainingpartner.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingpartner.controllers.TrainingDiaryController;
import com.trainingpartner.functions.database.DatabaseOperations;
import com.trainingpartner.tools.Tools;

/**
 * Servlet for Saving Diary
 */
@WebServlet("/SaveDiary")
public class SaveDiary extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger("com.trainingpartner.main.SaveDiary");
    private final ArrayList<String> alRequestParametersList = new ArrayList<String>(Arrays.asList("diaryName","diaryCreator", "diaryCreationDate", "diaryDescription", "trainingProgram"));
    
	public SaveDiary()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		log.info("Method for saving diary is running");
		
		HashMap<String, String> DiaryMap = new HashMap<String,String>();
		DiaryMap=Tools.GetDataFromRequest(request, alRequestParametersList);
		String sDiaryName = DiaryMap.get("diaryName");
		
		 if(TrainingDiaryController.SaveDiary(DiaryMap, sDiaryName)==true)
	        {
	        	response.sendRedirect("/TrainingPartnerProject/main.jsp");
	        }
		//body for method for saving diaries	
	}

}
