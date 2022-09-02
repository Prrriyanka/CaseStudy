package com.cg.casestudy.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.cg.casestudy.beans.Customer;
import com.cg.casestudy.services.CustService;
import com.cg.casestudy.services.CustServiceImpl;



public class MainClass {

	static List<Customer> wdb=new ArrayList<Customer>();
	static Scanner sc1;
	static String requserName="";
	static String reqpass="";
	static int totalAttempts= 5; 

	public static void main(String[] args) {

		CustService service=new CustServiceImpl();

		int opt=0;
		do
		{
			sc1=new Scanner(System.in);
			System.out.println("*************************************");
			System.out.println("-------------------------------------");
			System.out.println("Menu: \n1.Create Account \n2.Log in \n3.Log out \n4.Exit");
			System.out.println("-------------------------------------");
			System.out.println("*************************************");
			opt=sc1.nextInt();
//----------------------------OPTION 1-----------------------------------------------
			if(opt==1)
			{
				sc1=new Scanner(System.in);
				System.out.println("Enter your User Name");
				String userName=sc1.nextLine();

				System.out.println("Enter your password(atleast 8 letters,must include 1 DIGIT,1 SPCL CHARACHTER,1 UPPERCASE,NO SPACE allowed");
				String passWord=sc1.nextLine();

				System.out.println("Enter your City");
				String city=sc1.nextLine();

				System.out.println("Enter your Age");
				String age=sc1.nextLine();

				Customer customer=new Customer(userName,passWord,age,city);
				boolean validate=service.validateUserDetails(customer);			
				if (validate) {
					Customer userNew=service.registerCustomer(customer);
					System.out.println("New customer added- "+userNew);
				}
				else {
					System.out.println("EXITED");
					opt=4;
				}}


//----------------------------OPTION 2-----------------------------------------------


			if(opt==2)
			{
				System.out.println("Enter you Username");
				sc1=new Scanner(System.in);
				String user =sc1.nextLine();
				System.out.println("Enter you Password");
				String pass=sc1.nextLine();


				String loginFlag=service.loginCustomer(user, pass);

				if (totalAttempts != 0) {
					//--------ADMIN LOGIN------------------------------
					if(loginFlag=="admin")
					{
						int opt1=0;
						requserName=user;
						reqpass=pass;
						System.out.println("Admin Login Succesfull");
						do {
							sc1=new Scanner(System.in);
							System.out.println("*************************************");
							System.out.println("-------------------------------------");
							System.out.println("Menu: \n1.Show all customers\n2.Delete customer a/c  \n3.Log out");
							System.out.println("-------------------------------------");
							System.out.println("*************************************");
							opt1=sc1.nextInt();

							if (opt1==1) {
								List<Customer> custList;
								custList = service.showAllCustomer();
								for(int i=0;i<custList.size();i++) {
									System.out.println(custList.get(i));
								}
							}
							else if (opt1==2) {
								System.out.println("Enter id to delete");
								int id=sc1.nextInt();
								boolean deletedValue=service.deleteCustomer(id);
								if(deletedValue==true)
									System.out.println(id+" -id Record Deleted Succesfully");
								else
									System.out.println("Deleteion failed");
							}
							else if(opt1==3){
								requserName="";
								reqpass="";
								System.out.println("You are successfully logged out");
							}
						}while (opt1!=3);
					}


					//--------DEVELOPER LOGIN------------------------------
					else if (loginFlag=="developer")
						{
						requserName=user;
						reqpass=pass;
						System.out.println("Developer Login Succesfull");				
						}
					//--------USER LOGIN------------------------------
					else if (loginFlag=="user")
						{
						requserName=user;
						reqpass=pass;
						System.out.println("User Login Succesfull");				
						}
					else 
						{
						totalAttempts--;
						System.out.println("--Error-- \nInvalid credentials\nRemaining attempts-->"+totalAttempts);
						}}
					else 
					{
					System.out.println("maximum number of attemps exceeded");
					opt=4;
					}
				}
			
//----------------------------OPTION 3-----------------------------------------------

			else if(opt==3)
			{
				requserName="";
				reqpass="";
				System.out.println("You are successfully logged out");
			}
		}while(opt!=4);


	}}
