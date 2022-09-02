package com.cg.casestudy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.casestudy.beans.Customer;
import com.cg.casestudy.daos.CustomerDAO;
import com.cg.casestudy.daos.CustomerDAOImpl;


@WebServlet("/delete")
public class DeleteRecordAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO=new CustomerDAOImpl();
  
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =request.getRequestDispatcher("admindelete.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		 int   deleteid = Integer.parseInt(id);
		boolean del=customerDAO.delete(deleteid);
		
		PrintWriter out = response.getWriter();	
		
		if(del==true) {
		out.println("<script type=\"text/javascript\">"); 
		out.println("alert('id deleted succesfully');"); 
		out.println("location='adminloginsuccessful.jsp';"); 
		out.println("</script>"); 
		}
		else {
			out.println("<script type=\"text/javascript\">"); 
			out.println("alert('Error');"); 
			out.println("location='adminloginsuccessful.jsp';"); 
			out.println("</script>"); 
		}
	}

}
