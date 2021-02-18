package com.valuemomentum.training.JdbcDemo1;

import java.sql.*;

public class JoinsDemo {

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
        	rs=stmt.executeQuery("select c.id,first_name,name from candidates c INNER JOIN  candidate_skills s ON c.id=candidate_id  INNER JOIN  skills sk ON s.skill_id=sk.id  ;");
        	while(rs.next()) {
        		System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
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


