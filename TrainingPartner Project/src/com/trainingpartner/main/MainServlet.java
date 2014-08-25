package com.trainingpartner.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trainingpartner.controllers.TrainingDiaryController;
import com.trainingpartner.controllers.UserController;
import com.trainingpartner.functions.database.DatabaseOperations;
import com.trainingpartner.tools.Tools;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(description = "Main servlet in project", urlPatterns = { "/MainServlet" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    	static Logger log = Logger.getLogger("com.trainingpartner.main.MainServlet");
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        // get request parameters for userID and password
		
        String user = request.getParameter("username");
        String pwd = request.getParameter("password");
        String hpwd = Tools.HashPassword(pwd);
        boolean bUserExist = UserController.CheckLoginCreditentials(user, hpwd);
        //Here we would check, if user and password from input equals some of the users from database 
        if(bUserExist)
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30*60);
            response.addCookie(userName);
            response.sendRedirect("main.jsp");
        }
        else
        {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/main.jsp");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
	}

}
