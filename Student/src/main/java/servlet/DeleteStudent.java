package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import stud.StudService;
import stud.studservicemp;

public class DeleteStudent extends HttpServlet{
 private StudService sservice;
 
 public void init() {
	 sservice=new studservicemp();
 }
 public void doGet(HttpServletRequest request,HttpServletResponse response)
 throws IOException,ServletException {
	 
 int id=Integer.parseInt(request.getParameter("id"));
 int n=sservice.deletestudent(id);
 RequestDispatcher rd= (RequestDispatcher) request.getRequestDispatcher("student");
	rd.forward(request, response);
   }
}