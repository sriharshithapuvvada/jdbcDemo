package com.valuemomentum.training.JdbcDemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
     	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","Gudur@123");
        System.out.println("Driver is loaded");
     	Statement stmt=con.createStatement();
     	con.setAutoCommit(false);
     	try {
     		int i1=stmt.executeUpdate("insert into candidate_skills values(50,3)");
     		int i2=stmt.executeUpdate("update skills set name='Ruby' where id=1");
     		int i3=stmt.executeUpdate("delete from candidates where id=34");
     		con.commit();
     		System.out.println("Transcation is sucess");
     	}
     	catch(Exception e) {
     		try {
     			con.rollback();
     			System.out.println("Transaction is failed");
     		}
     		catch(Exception ex) {
     			System.out.println(ex);
     	}

	}
     	stmt.close();
     	con.close();
     	System.out.println("connection is closed");
     	
	}
}
