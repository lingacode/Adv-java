package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest3_TryWithResource {

	public static void main(String[] args) {
		
		try( // establish the connection
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
				// create the JDBC Statement object
				Statement st = con.createStatement();
				// send and execute the sql query
				ResultSet rs=st.executeQuery("SELECT COUNT (*) FROM EMP")){
			// process the resultset object
			if (rs != null)
				rs.next();
			 System.out.println("Emp db table records count is::"+rs.getInt("count(*)"));//or
			//System.out.println("Emp db table records count is ::" + rs.getInt(1));
		} // try
		catch (SQLException se) {// For known exception
			se.printStackTrace();
		} catch (Exception e) {// for unknown exception
			e.printStackTrace();
		} 
	}// main
}// class
