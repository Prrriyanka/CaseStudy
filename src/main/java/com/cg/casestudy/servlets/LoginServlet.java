package com.cg.casestudy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.casestudy.daos.CustomerDAO;
import com.cg.casestudy.daos.CustomerDAOImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO=new CustomerDAOImpl();
//	static int totalAttempts= 3;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =request.getRequestDispatcher("LoginPage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String userName=request.getParameter("userName");
		String PassWord=request.getParameter("passWord");
		
		int totalAttempts=customerDAO.fetchTotalAttempts(userName);

		System.out.println(customerDAO.login(userName,PassWord));

		System.out.println("hehnfjeciojncdn"+!customerDAO.accisBlocked(userName));
		System.out.println("totalattempts----------------------"+totalAttempts);
		PrintWriter out = response.getWriter();
		
		
		if(customerDAO.userExist(userName))
		{
		if(!customerDAO.accisBlocked(userName))
		{
			if (customerDAO.fetchTotalAttempts(userName) > 1) 
			{
				if (customerDAO.login(userName,PassWord)=="user") 
				{
				    HttpSession session = request.getSession();
					session.setAttribute("admin", userName);
				
					//setting session to expiry in 30 mins
					session.setMaxInactiveInterval(30*60);
					Cookie adminName = new Cookie("user", userName);
					adminName.setMaxAge(30*60);
					response.addCookie(adminName);
					
					RequestDispatcher dispatcher =request.getRequestDispatcher("/userloginsuccessful.jsp");
					dispatcher.forward(request, response);
					
					//totalAttempts=3;
				    customerDAO.resetTotalAttempts(userName);		
				}
				else if (customerDAO.login(userName,PassWord)=="admin") 
				{
				    
				    HttpSession session = request.getSession();
					session.setAttribute("admin", userName);
				
					//setting session to expiry in 30 mins
					session.setMaxInactiveInterval(30*60);
					Cookie adminName = new Cookie("user", userName);
					adminName.setMaxAge(30*60);
					response.addCookie(adminName);
				    
					RequestDispatcher dispatcher =request.getRequestDispatcher("/adminloginsuccessful.jsp");
					dispatcher.forward(request, response);
					//totalAttempts=3;
					 customerDAO.resetTotalAttempts(userName);
				
				}
				else if (customerDAO.login(userName,PassWord)=="developer") 
				{
				    HttpSession session = request.getSession();
					session.setAttribute("admin", userName);
				
					//setting session to expiry in 30 mins
					session.setMaxInactiveInterval(30*60);
					Cookie adminName = new Cookie("user", userName);
					adminName.setMaxAge(30*60);
					response.addCookie(adminName);
					
					RequestDispatcher dispatcher =request.getRequestDispatcher("/developerloginsuccessful.html");
					dispatcher.forward(request, response);
				//	totalAttempts=3;
					
					customerDAO.resetTotalAttempts(userName);
				}
				/*
				 * else if(customerDAO.login(userName,PassWord)=="error") { //404 display image
				 * +button out.println("<script type=\"text/javascript\">");
				 * out.println("alert('No such user found ');");
				 * out.println("location='LoginPage.jsp';"); out.println("</script>"); }
				 */
				else if (customerDAO.login(userName,PassWord)=="passwordnotmatch") {
					
					totalAttempts--;
					customerDAO.resetTotalAttempts(userName,totalAttempts);
					System.out.println("totalattempts----000000"+totalAttempts);
					
					out.println("<script type=\"text/javascript\">"); 
					out.println("alert('Invalid password...Attemps left "+totalAttempts+"');"); 
					out.println("location='LoginPage.jsp';"); 
					out.println("</script>"); 
				}
			}
			else
			{
				out.println("<script type=\"text/javascript\">"); 
				out.println("alert('Account blocked,kindly contact administrator');"); 
				out.println("location='index.html';"); 
				out.println("</script>"); 
				customerDAO.blockacc(userName);
				totalAttempts=3;
			}
		}
		else {	response.sendRedirect("blockedAccount.jsp");
			totalAttempts=3;}
		
	}
		
		else {
			
			//404 display image +button
			out.println("<script type=\"text/javascript\">"); 
			out.println("alert('No such user found ');"); 
			out.println("location='LoginPage.jsp';"); 
			out.println("</script>"); 
		
	}
		out.close();
		
	}
}
