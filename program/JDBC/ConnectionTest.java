import java.sql.*;
public class ConnectionTest{
	public static void main(String[] args)throws Exception{
	//Activate jdbc driver s/w

		//load jdbc driver class
		  //Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
	/*	//create jdbc driver object
		oracle.jdbc.driver.OracleDriver driver=new oracle.jdbc.driver.OracleDriver();
		//register jdbc driver s/w with DriverManager service
		DriverManager.registerDriver(driver);*/
		
		
		//Establish the connection with DB s/w
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		System.out.println("jdbc con object class name::"+con.getClass());
		//check the connection
		if(con==null)
			System.out.println("connection is not established");
		else
			System.out.println("connection is established");
			
			
			//create JDBC Statement object
			Statement st = con.createStatement();
			System.out.println("JDBC Statement obj class name:"+st.getClass());
	}
}
		