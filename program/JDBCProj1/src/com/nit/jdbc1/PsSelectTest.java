package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PsSelectTest {
	private static final String GET_EMP_QUERY="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	
	public static void main(String[] args) {
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
				PreparedStatement ps=con.prepareStatement(GET_EMP_QUERY);	
				ResultSet rs=ps.executeQuery();
				){
			//process the resultset object
			if(rs!=null) {
				boolean isRSEmpty=false;
				while(rs.next()) {
					isRSEmpty=false;
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4)+" "+rs.getInt(5));
				}//while
				if(isRSEmpty) {
					System.out.println("NO Records found -- Table is Empty");
				}
				else
					System.out.println("Records found and displayed as shown above");
			}//if
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//,main

}//class
