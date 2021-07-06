package stud;

import java.util.ArrayList;

import com.demo.dao.studentDAO;

import bean.student;

public class studservicemp implements StudService {

	studentDAO sdao;
	public studservicemp()
	{
		super();
		sdao=(studentDAO) new studservicemp();
	}
	public ArrayList<student>getAllstudent() {
		
		return sdao.getStudent();
	}
	@Override
	public student getbyid(int sid) {
		
		return sdao.getstudentByid(sid);
	}

	@Override
	public int updatestudent(student s1) {
		
		return sdao.updatestudentData(s1);
	}

	@Override
	public int addstudent(student s1) {
		
		return sdao.insertstudent(s1);
	}

	@Override
	public int deletestudent(int id) {
		
		return sdao.deletestudent(id);
	}

}
