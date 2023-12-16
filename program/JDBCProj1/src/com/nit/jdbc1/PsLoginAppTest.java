package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class PsLoginAppTest {
	private static final String  AUTH_QUERY="SELECT COUNT(*) FROM USERSINFO WHERE USERNAME=? AND PASSWORD=?";

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in);
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			    PreparedStatement ps=con.prepareStatement(AUTH_QUERY)
				){
			//read input values from enduser
			String user=null,pass=null;
			if(sc!=null) {
				System.out.println("Enter username::");
				user=sc.nextLine();//takes raja
				System.out.println("enter password::");
				pass=sc.nextLine();//take rani
			}
			
			if(ps!=null) {
				//set input values SQL Query params
				ps.setString(1,user);
				ps.setString(2, pass);
			}
				//send and execute the SQL Query
				try(ResultSet rs=ps.executeQuery()){
					//process the Resulset obj
					if(rs!=null) {
						rs.next();
						int count=rs.getInt(1);
						
						if(count==0)
							System.out.println("invalid Credential");
						else
							System.out.println("valid Credential");
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
