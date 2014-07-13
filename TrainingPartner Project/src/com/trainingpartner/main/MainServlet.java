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

import com.trainingpartner.dao.LoginDao;
import com.trainingpartner.functions.database.DatabaseOperations;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(description = "Main servlet in project", urlPatterns = { "/MainServlet" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private final String userID = "Pankaj";
	    private final String password = "journaldev";
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
		DatabaseOperations.InsertData();
		
        String user = request.getParameter("username");
        String pwd = request.getParameter("password");
         
        if(userID.equals(user) && password.equals(pwd))
        {
            HttpSession session = request.getSession();
            session.setAttribute("user", "Pankaj");
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
