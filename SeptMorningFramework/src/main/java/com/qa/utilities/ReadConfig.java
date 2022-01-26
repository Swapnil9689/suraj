package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	public ReadConfig ()
	{
		File src =new File("C:\\Users\\232338\\eclipse-workspace\\SeptMorningFramework\\src\\main\\java\\com\\qa\\configfiles\\config.properties");
		try 
		{
			FileInputStream fis=new FileInputStream(src);
			pro =new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getApplicationURL()
	{
		String baseURL = pro.getProperty("URL");
		return baseURL;
	}
	
	public String getEmail()
	{
		String email = pro.getProperty("email");
		return email;
	}
	public String getPass()
	{
		String pass = pro.getProperty("password");
		return pass;
	}
	
	

}
