package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import stud.LoginStud;
import stud.Loginstudmp;

public class Loginservlet extends HttpServlet{
	
	private LoginStud lstud;
	public void init() {
		lstud=new Loginstudmp();
	}
	 
	public void doPost(HttpServletRequest request,HttpServletResponse response)
 throws IOException,ServletException {
		PrintWriter out= response.getWriter();
		String uname=request.getParameter("user");
		String pass=request.getParameter("pass");
		boolean flag=lstud.validateUser(uname, pass);
		if(flag) {
			HttpSession sess=request.getSession();
			sess.setAttribute("user", uname);
			RequestDispatcher rd= request.getRequestDispatcher("student");
			rd.forward(request, response);
		}else
		{
			out.println("<h3> Pls Enter Valid Details</h3>");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}
}
