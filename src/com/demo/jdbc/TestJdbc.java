package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_one_to_one?useSSL=false";
		String user="hbstudent";
		String pass="hbstudent";
		try {
	System.out.println("Connecting to database: "+jdbcUrl);
Connection con=DriverManager.getConnection(jdbcUrl,user,pass);
		System.out.println("Connection Successfull");
		}catch(Exception e) {
	e.printStackTrace();
}
	}

}
