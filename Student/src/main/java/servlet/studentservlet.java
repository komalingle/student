package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.student;
import stud.StudService;
import stud.studservicemp;

public class studentservlet extends HttpServlet{
private StudService sservice;
	
	public void init() {
		sservice =new studservicemp();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			 throws IOException,ServletException {
		PrintWriter out= response.getWriter();
		ArrayList<student> slist=sservice.getAllstudent();
		out.println("<table border='2'><tr><th> Stud id </th><th>Stud Name</th>"
				+ "<th>Stud dob</th><th> Stud doj</th></tr>");
		for(student s:slist) {
			out.println("<tr><td>"+s.getid()+"</td><td>"+s.getname()+"</td><td>"+s.getdob()+"</td><td>"+s.getdoj()+"</td>");
			out.println("<td><a href='deleteprod?sid="+s.getid()+"'>delete</a>/<a href='editprod?sid="+s.getid()+"'>edit</a></td></tr>");
			
		}
		out.println("</table>");
		out.println("<a href='AddStudent.html'>Add Stud</a>");
		/*out.println("<button type='submit'>Add</button>");
		out.println("</form>");*/
		/*for(student s:slist) {
			out.println("<tr><td>"+s.getid()+"</td><td>"+s.getname()+"</td><td>"+s.getdob()+"</td><td>"+s.getdoj()+\"</td>");
			out.println("<td><a href='deleteprod?sid="+s.getid()+"'>delete</a>/<a href='editprod?sid="+s.getid()+"'>edit</a></td></tr>");
			
		}*/
	}
}
