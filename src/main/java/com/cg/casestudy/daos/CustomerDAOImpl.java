package com.cg.casestudy.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import com.cg.casestudy.beans.Customer;
import com.cg.casestudy.utils.DBUtil;



public class CustomerDAOImpl implements CustomerDAO{
	private Connection connection= DBUtil.getDBConnection();
	static String adminString="admin";
	static String developerString="developer";
	static String userString="user";
	static int totalAttempt=3;

	@Override
	public String register(Customer customer) {
		try {
			PreparedStatement pstmt = connection.prepareStatement("insert into Customer(userName,password,email,phoneno,role,totalAttempts)values(?,?,?,?,?,?)");
			pstmt.setString(1, customer.getUserName());
			pstmt.setString(2, customer.getPassword());
			pstmt.setString(3, customer.getEmail());
			pstmt.setString(4, customer.getPhoneNo());
			pstmt.setString(5, userString);
			pstmt.setInt(6, totalAttempt);
			


			//DML
			int rowsEffected=pstmt.executeUpdate();
			System.out.println(rowsEffected+"rows inserteddd");

			pstmt=connection.prepareStatement("Select max(id) from Customer");
			ResultSet rs =pstmt.executeQuery();
			if(rs.next())
				customer.setId(rs.getInt(1));
			return "success";

		}
		catch (SQLException e) 
		{e.printStackTrace();}
		return "failed";
	}

	@Override
	public String login(String userName,String passwordString) {


		try {
			PreparedStatement pstmt=connection.prepareStatement("Select * from Customer Where userName=?");
			pstmt.setString(1,userName);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				Customer cust=new Customer(rs.getInt("id"),rs.getString("userName"),rs.getString("password"),rs.getString("email"),rs.getString("phoneno"),rs.getString("role"));

				if (userName.equals(cust.getUserName())&&(!passwordString.equals(cust.getPassword()))) 
				{
					return "passwordnotmatch";
				}
				else if (userName.equals(cust.getUserName())&&(passwordString.equals(cust.getPassword()))) 
				{
					if((cust.getRole()).equals(adminString))
					{return "admin";		}
					else if (cust.getRole().equals(developerString)) 
					{return "developer";	}
					else 
					{return "user";			}

				}	
			}
		} catch (SQLException e)	{	e.printStackTrace();}
		return "error";
	}

	@Override
	public boolean delete(int id) {
		try {
			PreparedStatement psmt = connection.prepareStatement("delete from customer where(id=?)");
			psmt.setInt(1, id);
			int count = psmt.executeUpdate();
			System.out.println(count+" row got deleted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public List<Customer> showAll() {
		ArrayList<Customer> custList=new ArrayList<>();
		try {
			ResultSet rs=connection.prepareStatement("select * from customer").executeQuery();
			while (rs.next())
				custList.add(new Customer(rs.getInt("id"),rs.getString("userName"),rs.getString("password"),rs.getString("email"),rs.getString("phoneno"),rs.getString("role"),rs.getBoolean("accisBlocked")));
			return custList;

		}catch(SQLException e) {e.printStackTrace();}
		return custList;
	}

	@Override
	public boolean validate(Customer customer) {

		//-----FULL NAME-------------------------------
		if(customer.getUserName().trim().equals(""))
		{
			System.out.println("--Error--\nUser name can't be blank");
			return false;
		}	

		if(Pattern.matches("^(?=\\\\S+$)(?=.*[@#$%^&+=])$", customer.getPassword()))
		{
			System.out.println("--Error--\nUser name can't have blank spaces or spcl chars");
			return false;
		}
		//-----PASS WORD-------------------------------

		String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";

		if(customer.getPassword().trim().equals(""))
		{
			System.out.println("--Error--\nEnter valid password");
			return false;
		}
		else if(!Pattern.matches(regex, customer.getPassword()))
		{
			System.out.println("--Error--\nPlease follow Password rules \nDigit must occur at least once. \nLower case alphabet must occur at least once. \nUpper case alphabet that must occur at least once. \nSpecial character that must occur at least once. \nSpaces are not allowed in the Password. \nAt least 8 characters and at most 20 characters.");
			return false;
		}

		//------City-------------------------------------
		if(customer.getEmail().trim().equals(""))
		{
			System.out.println("--Error--\nCity can't be blank");
			return false;
		}

		//------Age-------------------------------------
		//		if(customer.getAge()<=0 || customer.getAge()>=150)
		//		{
		//			System.out.println("--Error--\nEnter valid age");
		//			return false;
		//		}

		return true;
	}

	@Override
	public boolean accisBlocked(String userName) {
		try {
			PreparedStatement pstmt=connection.prepareStatement("Select * from Customer Where userName=?");
			pstmt.setString(1,userName);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				Customer cust = new Customer(rs.getInt("id"),rs.getString("userName"),rs.getString("password"),rs.getString("email"),rs.getString("phoneno"),rs.getString("role"),rs.getBoolean("accisBlocked"));

				if (cust.getAccisBlocked())
				{
					return true;
				}}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void blockacc(String userName) {
		String status ="true";

		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement("UPDATE customer SET accisBlocked = ? WHERE userName = ?");
			pstmt.setString(1, status);
			pstmt.setString(2, userName);

			int rowsEffected=pstmt.executeUpdate();
			System.out.println("rowwsss affectedd-------"+rowsEffected);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public boolean userExist(String userName) {
		try {
			PreparedStatement pstmt=connection.prepareStatement("Select * from Customer Where userName=?");
			pstmt.setString(1,userName);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				String Countrow = rs.getString(1);
				if(!Countrow.equals("0")){
					return true;	}
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean emailExist(String emailId) {
		try {
			PreparedStatement pstmt=connection.prepareStatement("Select * from Customer Where email=?");
			pstmt.setString(1,emailId);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				String Countrow = rs.getString(1);
				if(!Countrow.equals("0")){
					return true;	}
			}} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public void resetTotalAttempts(String userName) {
		// TODO Auto-generated method stub
		int attempts=5;

		try {
			PreparedStatement pstmt = connection.prepareStatement("UPDATE customer SET totalAttempts = ? WHERE userName = ?");
			pstmt.setInt(1, attempts);
			pstmt.setString(2, userName);

			int rowsEffected=pstmt.executeUpdate();
			System.out.println("rowwsss affectedd-------"+rowsEffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	
	@Override
	public void resetTotalAttempts(String userName,int attempts) {
		
		try {
			PreparedStatement pstmt = connection.prepareStatement("UPDATE customer SET totalAttempts = ? WHERE userName = ?");
			pstmt.setInt(1, attempts);
			pstmt.setString(2, userName);

			int rowsEffected=pstmt.executeUpdate();
			System.out.println("rowwsss affectedd-------"+rowsEffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	@Override
	public int fetchTotalAttempts(String userName) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt;
		int attempts = 0;
		try {
			
			pstmt = connection.prepareStatement("Select * from Customer Where userName=?");
			pstmt.setString(1,userName);
			ResultSet rs=pstmt.executeQuery();
			if (rs.next()) {
				Customer cust = new Customer(rs.getInt("id"),rs.getString("userName"),rs.getString("password"),rs.getString("email"),rs.getString("phoneno"),rs.getString("role"),rs.getBoolean("accisBlocked"),rs.getInt("totalAttempts"));
				attempts=cust.getTotalAttempts();
			return attempts;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return 0;
	}
	



}
	
	
	
