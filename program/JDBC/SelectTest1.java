//SelectTest1.java
package com.nit.jdbc;
/* 
	App to get Employee details based on given initial characters of the employee's name
	author:Team-s
	version:1.0;
*/
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest1{
	public static void main(String[] args){
		
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try{
			//read inputs from the Enduser
			sc = new Scanner(System.in);
			String initChars=null;
			if(sc!=null){
				System.out.println("Enter the initial characters of employee name::");
				initChars=sc.next();//gives s
			}
			//convert the input values as required the sql querry
			initChars = "'"+initChars+"%'";//gives 'S%'
		
		
			//Load jdbc driver class class(optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			
			//establish the connection with DB s/w  With
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			//create jdbc Statement object
			if(con!=null)
				st = con.createStatement();
				
			//prepare the sql Query
			//SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE 'S%' ORDER BY JOB
			String query = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE ENAME LIKE "+initChars+" ORDER BY JOB";
		
		    //execute the SQL Query
			if(st!=null)
				rs = st.executeQuery(query);
				
			//process the ResultSet
			
			if(rs!=null){
				boolean isRSEmpty = true;
				while(rs.next()){
					isRSEmpty = false;
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4)+" "+rs.getInt(5));
				}//while
				
				if(isRSEmpty)// is equal to if(isRSEmpty==true)
					System.out.println("No records found");
				else
					System.out.println("records are found and display");
			}//if
		}//try
		catch(SQLException se){//for handling known Exception
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf){//for handling known exception
			cnf.printStackTrace();
		}
		catch(Exception e){//for handling unknown exception
			e.printStackTrace();
		}
		finally{
			/* //Bad code to close jdbc objs in finally block
			try{
				if(rs!=null && st!=null && con!=null){
					rs.close();
					st.close();
					con.close();
				}	
			}
			catch(SQLException se){
				se.printStackTrace();
			}*/
			
			//Best code to close jdbc objs
			try{
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(st!=null)
					st.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(con!=null)
					con.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
				
		}//finally
		
		
		
	}//main
}//class
			