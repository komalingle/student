package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.core.StandardService;

import bean.student;
import stud.StudService;
import stud.studservicemp;

public class Editstudent extends HttpServlet{
 
	private StudService sservice;
	
	public void init() {
		sservice =new studservicemp();
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
	 throws IOException {
		PrintWriter out= response.getWriter();
		int sid= Integer.parseInt(request.getParameter("sid"));
		student s2 =sservice.getbyid(sid);
		
		out.println("<form action='updatestudent'>");
		out.println("id :<input type='text' name='id' value="+s2.getid()+"readonly>");
		out.println("name :< input type='text' name='sname' value="+s2.getname()+">");
		out.println("dob :<input type='text' name='dob' value="+s2.getdob()+">");
		out.println("doj :<input type='text' name='doj' value="+s2.getdoj()+">");
		out.println("<input type='submit' name='btn' value='update'>");
		out.println("</form>");
	}
}
