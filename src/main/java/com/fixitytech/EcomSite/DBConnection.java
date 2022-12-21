package com.fixitytech.EcomSite;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;
	public static Connection getConnection() {
		
		if(con==null) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");	
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomsitedb", "root", "yash123@");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
    return con;	
	}

}
