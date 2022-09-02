package com.cg.casestudy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cg.casestudy.beans.Customer;
import com.cg.casestudy.daos.CustomerDAO;
import com.cg.casestudy.daos.CustomerDAOImpl;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO=new CustomerDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("custList", customerDAO.showAll());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/adminloginsuccessful.jsp");
		dispatcher.forward(request, response);
	} 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

		PrintWriter out = response.getWriter();  
		Cookie ck[]=request.getCookies();  
		out.print("Hello admin "+ck[0].getValue());
		out.close();  
	}

}
