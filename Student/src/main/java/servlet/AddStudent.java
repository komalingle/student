package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import bean.student;
import stud.StudService;
import stud.studservicemp;

public class AddStudent extends HttpServlet{

	private StudService sservice;
	
	public void init() {
		sservice= new studservicemp();
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	throws IOException,ServletException{
		
		int id=Integer.parseInt(request.getParameter("id"));
		String sname=request.getParameter("sname");
		int dob=Integer.parseInt(request.getParameter("dob"));
		int doj=Integer.parseInt(request.getParameter("doj"));
		student s2= new student(id,sname,dob,doj);
		int n=sservice.addstudent(s2);
		RequestDispatcher rd=(RequestDispatcher) request.getRequestDispatcher("student");
		rd.forward(request, response);
	}
}
