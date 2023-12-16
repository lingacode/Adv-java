//selectTest.java

import java.sql.*; 

public class SelectTest{
	public static void main(String[] args)throws Exception{
		
		
		//establish the connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		//create JDBC statement object
		Statement st = con.createStatement();
		//prepare SQL Query
		String query="SELECT * FROM STUDENT";
		//send and execute SQL Query in DB s/w
		ResultSet rs = st.executeQuery(query);
		
		//process The ResultSet object
			while(rs.next()!=false){
				//System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getFloat(4));
				//System.out.println(rs.getInt("sno")+" "+rs.getString("sname")+" "+rs.getString("sadd")+" "+rs.getFloat("avg"));
			   System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			
			
		//close jdbc objs
		rs.close();
		st.close();
		con.close();
	}
}