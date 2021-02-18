package com.valuemomentum.training.JdbcDemo1;
// JDBC program to display records from candidates table in mysqljdbc 

import java.sql.*;

public class SelectDemo {

	public static void main(String[] args) {
		 Connection con;
	        Statement stmt;
	        ResultSet rs;
	        try {
	        	// register jdbc driver
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	
	        	// open a connection
	        	System.out.println("Connecting the data base....");
	        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Gudur@123");
	        	
	        	// create a statment object using connection object
	        	stmt= con.createStatement();
	        	
	        	// execute a query and retrive the data into result set
	        	rs=stmt.executeQuery("select * from candidates");
	        	
	        	// extract data from result set
	        	while(rs.next()) {
	        		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "
	        				+rs.getDate(4)+" "+rs.getString(5)+" "+rs.getString(6));
	        	}
	        	rs.close();
	        	stmt.close();
	        	con.close();
	        }
	        catch(Exception e) {
	        	System.out.println(e);
	        }       

	}

}
