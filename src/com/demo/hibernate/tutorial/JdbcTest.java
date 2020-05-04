package com.demo.hibernate.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) {
		 String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=Abc";
         String user = "sa";
         String pass = "enter";
         Connection con=null;
try {
	System.out.println("connecting to database"+dbURL);
    con=DriverManager.getConnection(dbURL, user, pass);
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from student");
	while(rs.next()) {
		System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getString(3));
	}
	System.out.println("connection successfully!!!!!!!");
	
} catch (Exception e) {
	 e.printStackTrace();
}finally {
    try {
        if (con != null && !con.isClosed()) {
        	System.out.println("connected");
            con.close();
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}
	}

}
