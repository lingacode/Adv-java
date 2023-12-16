package com.nit.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLSelectTest {
	
	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql:///NTAJ415DB","root","admin@123");
				Statement st = con.createStatement();
				ResultSet rs =  st.executeQuery("SELECT * FROM PRODUCT"); ){
			
			//process the resultset object
			if(rs!=null) {
				boolean isRSEmpty=false;
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getFloat(3)+" "+rs.getFloat(4));
				}//while
			}
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
				
	}//main

}//class
