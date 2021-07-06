package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.student;

public class Studentdaostu implements studentDAO{

	public static Connection conn;
	public static PreparedStatement sget,sbyid,supdate,sins,sdel;
	static
	{
		conn=DBUtill.getMyConnection();
		try {
			sget=conn.prepareStatement("select * from student");
			sbyid=conn.prepareStatement("select * from student where sid=?");
			supdate=conn.prepareStatement("update student set sname=?, sdob=?, sdoj=?");
			sins=conn.prepareStatement("insert into student(sid, sname,sdob,sdoj) values(?,?,?)");
			sdel=conn.prepareStatement("delete from student where sid=?");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<student> getStudent() {
		// TODO Auto-generated method stub
		ArrayList<student> slist=null;
		try {
			slist=new ArrayList<>();
			ResultSet s=sget.executeQuery();
			while(s.next())
			{
				student s1= new student(s.getInt(1),s.getString(2),s.getInt(3),s.getInt(4));
				slist.add(s1);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return slist;
	}

	@Override
	public student getstudentByid(int id) {
		try {
			sbyid.setInt(1, id);
			ResultSet s=sget.executeQuery();
			if(s.next())
			{
				student s1=new student(s.getInt(1),s.getString(2),s.getInt(3),s.getInt(4));
				return s1;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	//@Override
	public int updatestudentData(student s) {
		try {
			supdate.setInt(1, s.getid());
			supdate.setString(2, s.getname());
			supdate.setInt(3, s.getdob());
			supdate.setInt(4, s.getdoj());
			return supdate.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertstudent(student s) {
		try {
			sins.setInt(1, s.getid());
			sins.setString(2, s.getname());
			sins.setInt(3, s.getdob());
			sins.setInt(4, s.getdoj());
			return sins.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	

	@Override
	public int deletestudent(int id) {
		try {
			sdel.setInt(1, id);
			return sdel.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}

}
