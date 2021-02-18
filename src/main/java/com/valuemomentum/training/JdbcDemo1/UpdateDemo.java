package com.valuemomentum.training.JdbcDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDemo {

	public static void main(String[] args) {
		 Connection con;
	     PreparedStatement pstmt;
	     ResultSet rs;
	     int cnt=0;
	     try {
	        	// register jdbc driver
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Gudur@123");
            String sqlUpdate="Update candidates "+"SET last_name=? "+"where id= ? ";
            pstmt=con.prepareStatement(sqlUpdate);
            // prepare data for update
            Scanner s=new Scanner(System.in);
            System.out.println("enter employee id");
            int eid=s.nextInt();
            System.out.println(" enter employee's new last name: ");
            String lastname=s.next();
            
            pstmt.setString(1, lastname);
            pstmt.setInt(2, eid);
            
            int rowAffected= pstmt.executeUpdate();
            System.out.println(String.format("row affected %d", rowAffected));
            
            // reuse the prepared statment
            lastname= "Grohe";
            eid=101;
            pstmt.setString(1, lastname);
            pstmt.setInt(2, eid);
            
            rowAffected= pstmt.executeUpdate();
            System.out.println(String.format(" Row affected %d", rowAffected));
            con.close();
	     }
	     catch(Exception e) {
	    	 System.out.println(e);
	     }
	     }

}
