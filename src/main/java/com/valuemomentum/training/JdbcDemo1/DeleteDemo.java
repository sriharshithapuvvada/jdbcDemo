package com.valuemomentum.training.JdbcDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteDemo {

	public static void main(String[] args) {
		    Connection con;
	        Statement stmt;
	        int cnt=0;
	        try {
	        	// register jdbc driver
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Gudur@123");
	        	String sql="Delete from candidates where rtrim(last_name) like\'L%e\';";
                System.out.println(" ");
                stmt=con.createStatement();
                cnt=stmt.executeUpdate(sql);
                if(cnt>0) {
                	System.out.println("record for young is deleted");
                }
                else
                {
                	System.out.println("Record not found");
                }
                con.close();
	}
	        catch(Exception ce) {
	        	System.out.println(ce);
	        }
	}

}
