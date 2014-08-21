package com.trainingpartner.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * Class which contains several different functions to different tasks
 */
public class Tools 
{

	static Logger log = Logger.getLogger("com.trainingpartner.tools.Tools");
	public static HashMap<String,String> GetDataFromRequest(HttpServletRequest request, ArrayList<String> alRequestParametersList)
	{
		HashMap<String,String> hmRequestData = new HashMap<String,String>();
		log.info("Getting data from request....");
		for(String sCurrentElement : alRequestParametersList)
		{
			hmRequestData.put(sCurrentElement, request.getParameter(sCurrentElement));
			
		}
	
		return hmRequestData;
		
	}
	
	
	public static String HashPassword(String passwordToHash)
	{
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        
		return generatedPassword;
	}
	
}
