package com.demo.dao;

import java.util.ArrayList;

import bean.student;

public interface studentDAO {

	ArrayList<student>getStudent();
	
	student getstudentByid(int id);
	
	int updatestudentData(student s);
	
	 int insertstudent(student s);
	 
	 int deletestudent(int id);
}
