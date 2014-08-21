package com.trainingpartner.main;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingpartner.functions.database.DatabaseOperations;

/**
 * Servlet used during registration process. It redirect to the registerError or registerSucceeed
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Registration() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	       
		try
		{
	    String sUsername = request.getParameter("username");
        String sPassword = request.getParameter("password");
        String sDescription = request.getParameter("description");
        
        boolean bRegistrationSucceed=DatabaseOperations.SaveUser(sUsername, sPassword, sDescription);
	        if(bRegistrationSucceed==false)
	        {
	        	response.sendRedirect("/TrainingPartnerProject/registerError.jsp");
	        	
	        }
	        else
	        {
	        	response.sendRedirect("/TrainingPartnerProject/registerSucceed.jsp");
	        }
		}
		catch(Exception e)
		{
			e.getMessage();
		}
        
	}

}
