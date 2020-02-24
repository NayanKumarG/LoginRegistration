package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection con = null;
	static
	{
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306?useSSL=false","nayan","nayan");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
	}
	public static Connection getConnection()
	{
		return con;
	}
	
}
