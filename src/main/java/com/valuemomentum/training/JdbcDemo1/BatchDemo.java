package com.valuemomentum.training.JdbcDemo1;

import java.sql.*;

public class BatchDemo {

	public static void main(String[] args) throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
     	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Gudur@123");
        Statement stmt=con.createStatement();
        
        // create batch
        stmt.addBatch("insert into candidate_skills value(100,5)");
        stmt.addBatch("update skills set name='Ajax' where id=3");
        stmt.addBatch("delete from candidates where id=80");
        
        // disable auto-commit mode
        con.setAutoCommit(false);
        try {
        	stmt.executeBatch(); // all the statments happen at one round trip
        	con.commit();
        	System.out.println("batch is sucessfully executed");
        }
        catch(Exception e) {
        	try {
        		con.rollback();
        		System.out.println("batch is failed");
        		System.out.println("Exception is "+e);
        	}
        	catch(Exception e1) {
        		System.out.println("Exception is"+e1);
        	}
        }
        
        // cleanup
        stmt.close();
        con.close();

	}

}
