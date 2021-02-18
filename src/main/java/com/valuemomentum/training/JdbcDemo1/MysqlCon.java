package com.valuemomentum.training.JdbcDemo1;

import java.sql.*;

public class MysqlCon {

    public static void main( String[] args )
    {
        	
        	
        Connection con;
        Statement stmt;
        ResultSet rs;
        try {
        	// register jdbc driver
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
        	// open a connection
        	System.out.println("Connecting the data base....");
        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Gudur@123");
        	// create a statment object using connection object
        	stmt= con.createStatement();
        	
        	// execute a query and retrive the data into result set
        	rs=stmt.executeQuery("select * from employees");
        	
        	// extract data from result set
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "
        				+rs.getString(4)+" "+rs.getString("email")+" "+rs.getString(6)+" "
        				+ rs.getInt(7)+" "+rs.getString(8));
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
