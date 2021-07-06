package stud;

import java.util.ArrayList;

import bean.student;

public interface StudService {

	ArrayList<student> getAllstudent() ;
		student getbyid(int sid);
		int updatestudent(student s1);
		int addstudent(student s1);
		int deletestudent(int id);
	
}
