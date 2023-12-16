package com.nit.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTest5_TryWithResource {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in);
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				Statement st = con.createStatement();
		){
			//read input from enduser
			String desg1=null,desg2=null,desg3=null;
			if(sc!=null) {
				System.out.println("Enter Desg1::");
				desg1=sc.next().toUpperCase();//gives CLERK
				System.out.println("Enter Desg2::");
				desg2=sc.next().toUpperCase();//gives BANK
				System.out.println("Enter Desg3::");
				desg3=sc.next().toUpperCase();//gives Teacher
			}
			//convert input va;ues as the required for the SQL Query
						//(' CLERK','BANK','Teacher')
			String cond ="('"+desg1+"' ,'"+desg2+"' ,'"+desg3+"')";
			
			//prepare the SQL Query
			   //SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN('CLERK','BANK','TEACHER')ORDER BY JOB;
			String query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN"+cond+"ORDER BY JOB";
			System.out.println(query);
			
			//send and execute the SQL Query in Db s/w
			try(ResultSet rs=st.executeQuery(query)){//nested try with resource
				
				//process the result obj
				if(rs!=null) {
					boolean isRSEmpty=true;
					while(rs.next()) {
						isRSEmpty=false;
						System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
					}//while
					if(isRSEmpty)
						System.out.println("No record found");
					else
						System.out.println("Record found and display");
				}//if
			
		}//try2
			
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//main

}//class
