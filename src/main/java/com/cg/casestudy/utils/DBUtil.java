package com.cg.casestudy.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import com.cg.casestudy.beans.Customer;


public class DBUtil {
	
	public static Connection getDBConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");    // Reflection API
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/casestudyjdbc" ,"root" ,"root");
			return con;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}	
}
