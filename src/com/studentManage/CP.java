package com.studentManage;

import java.sql.*;
public class CP {
	static Connection con;
	public static Connection createc() {
		
		try {
			
			//load the driver
			Class.forName("org.postgresql.Driver");
			//create the connection
			String user = "postgres"; //user of mysql
			String password = "subra123"; //password of mysql
			String url = "jdbc:postgresql://localhost:5432/postgres";
			
			
			
			con=DriverManager.getConnection(url,user,password);
			}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
}