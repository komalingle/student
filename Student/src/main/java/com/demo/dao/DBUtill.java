package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtill {
 
	private static Connection conn;
	
	public static Connection getMyConnection()
	{
		if(conn==null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");	
				System.out.println("Driver Loaded");
				conn= DriverManager.getConnection("jdbc:mysql://localhost/testdb?"+"user=myuser&password=mypwd");
				String url="jdbc:mysql://localhost:3304co/test";
				conn= DriverManager.getConnection(url,"root","root");
				
			}catch(SQLException | ClassNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		return conn;
	}
	 
	public static void closeMyConnection()
	{
		try
		{
			conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}
