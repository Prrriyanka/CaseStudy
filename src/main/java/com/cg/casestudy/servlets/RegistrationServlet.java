package com.cg.casestudy.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.casestudy.beans.Customer;
import com.cg.casestudy.daos.CustomerDAO;
import com.cg.casestudy.daos.CustomerDAOImpl;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDAO customerDAO=new CustomerDAOImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =request.getRequestDispatcher("RegistrationPage.html");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String PassWord=request.getParameter("passWord");
		String email=request.getParameter("email");
		String phone=request.getParameter("phoneno");
		
		Customer customer=new Customer();
		customer.setUserName(userName);
		customer.setPassword(PassWord);
		customer.setEmail(email);
		customer.setPhoneNo(phone);
		PrintWriter out = response.getWriter();	
		
		if(customerDAO.userExist(userName)!=true) {
			
		if(customerDAO.emailExist(email)!=true) {
			
		if(customerDAO.register(customer)!="failed") {
	
		RequestDispatcher dispatcher =request.getRequestDispatcher("/registrationSuccesful.jsp");
		dispatcher.forward(request, response);
		
		
		}
		else {
			RequestDispatcher dispatcher =request.getRequestDispatcher("RegistrationPage.html");
			dispatcher.forward(request, response);}
		
		}else {
			out.println("<script type=\"text/javascript\">"); 
			out.println("alert('email Id already registered');"); 
			out.println("location='RegistrationPage.html';"); 
			out.println("</script>"); 
		}	
		}
		else {
			out.println("<script type=\"text/javascript\">"); 
			out.println("alert('User Id already exist');"); 
			out.println("location='RegistrationPage.html';"); 
			out.println("</script>"); 
		}		
	}

}
