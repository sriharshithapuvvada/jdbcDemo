package com.valuemomentum.training.JdbcDemo1;

import java.sql.*;


public class ScrollableDemo {

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
        	stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); // scrollable result
        	rs=stmt.executeQuery("select * from skills");
        	// reading from bottom to top
        	rs.afterLast();
        	while(rs.previous()) {
        		System.out.println(rs.getInt(1)+" "+rs.getString(2));
        	}
        	System.out.println("**********************************");
        	// move the cursor to 3 rd record
        	rs.absolute(3);
        	System.out.println(rs.getInt(1)+" "+rs.getString(2));
        	System.out.println("***********************************");
        	
        	// move the cursor to 2nd record using relative()
        	rs.relative(-1); //  moves backward
        	System.out.println(rs.getInt(1)+" "+rs.getString(2));
        	System.out.println("***********************************");
        	
        	int i=rs.getRow();  // get cursor position
        	System.out.println("cursor position ="+i);
        	
        	//cleanup
        	rs.close();
        	stmt.close();
        	con.close();
        	
	}
        catch(Exception e) {
        	System.out.println(e);
        }
	}
}
