package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Logindaostu implements Logindao {
 
	public static Connection conn;
	public static PreparedStatement pre;
	
	@Override
	public boolean doAuthentication(String uname, String pass) {
		try
		{
			pre.setString(1, uname);
			pre.setString(2, pass);
			ResultSet s= pre.executeQuery();
			if(s.next()) {
				if(s.getString(1).equals(uname) && s.getString(2).equals(pass))
				{
					return true;
				}
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
