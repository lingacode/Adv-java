package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest4 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// Load jdbc driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

			// create the JDBC Statement object
			if (con != null)
				st = con.createStatement();

			// prepare the SQL Query
			String query = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE SAL=(SELECT MAX(SAL)FROM EMP)";

			// send and execute the sql query
			if (st != null)
				rs = st.executeQuery(query);

			// process the resultset object
			if (rs != null) {
				while (rs.next()) {
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "	+ rs.getFloat(4) + " " + rs.getInt(1));

				} // while
			} // if
		} // try
		catch (SQLException se) {// For known exception
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {// for known exception
			cnf.printStackTrace();
		} catch (Exception e) {// for unknown exception
			e.printStackTrace();
		} finally {
			// close the jdbc obj
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (st != null)
					st.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}

		} // finally
	}// main

}// class
