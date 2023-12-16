package com.nit.jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductsTransfersfromOracleToMySQL {
	private static final String  MYSQL_INSERT_QUERY="INSERT INTO PRODUCT VALUES(?,?,?,?)";
	private static final String  ORACLE_SELECT_QUERY="SELECT * FROM PRODUCT";   

	public static void main(String[] args) {

		try (Connection oraCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
				Connection mysqlCon = DriverManager.getConnection("jdbc:mysql:///ntaj415db1", "root", "admin@123");
				Statement oraSt=oraCon.createStatement();
				PreparedStatement mysqlPs=mysqlCon.prepareStatement(MYSQL_INSERT_QUERY);
				ResultSet oraRs=oraSt.executeQuery(ORACLE_SELECT_QUERY);
		) {
			//copy the records of ResulSet(oracle )to mysql db table
			if(oraRs!=null && mysqlPs!=null) {
				while(oraRs.next()) {
					//get each record from oracle RS
					int pid = oraRs.getInt(1);
					String pname=oraRs.getString(2);
					float price=oraRs.getFloat(3);
					float qty=oraRs.getFloat(4);
					//set vlaue INSERT SQL QUERY params to insert the record to MYSQL Db table
					mysqlPs.setInt(1,pid);
					mysqlPs.setString(2, pname);
					mysqlPs.setFloat(3, price);
					mysqlPs.setFloat(4, qty);		
					mysqlPs.executeUpdate();
					
				}//while
				System.out.println("Oracle Product Db table records are copied to MYSQL Product db table");
			}//if
		} // try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
