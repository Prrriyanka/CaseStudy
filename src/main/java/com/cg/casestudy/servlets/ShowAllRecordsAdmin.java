package com.cg.casestudy.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.casestudy.beans.Customer;
import com.cg.casestudy.daos.CustomerDAO;
import com.cg.casestudy.daos.CustomerDAOImpl;

@WebServlet("/showall")
public class ShowAllRecordsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerDAO = new CustomerDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 PrintWriter out = response.getWriter(); response.setContentType("text/html");
		 out.println("<html><body>");
		  
		  List<Customer> rs=customerDAO.showAll();
		  out.println("<table border=1 width=50% height=50%>"); for(int
		  i=0;i<rs.size();i++) { out.println("<tr><td>" +rs.get(i) + "</td><td>"); }
		  out.println("</table>"); out.println("</html></body>");
		  response.getWriter().append("Served at: ").append(request.getContextPath());
		 

		/*
		 * PrintWriter out = response.getWriter(); response.setContentType("text/html");
		 * List<Customer> rs=customerDAO.showAll(); request.setAttribute("list", rs);
		 * out.println("<table>");
		 * out.println("<c:forEach var='item' items='${list}'>"); out.println("<tr>");
		 * out.println("<td><c:out value='${item.id}'/></td>"); out.println("</tr>");
		 * out.println("</c:forEach>"); out.println("</table>");
		 */

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
