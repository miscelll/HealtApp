package application;

import java.sql.*;
public class ConnectionMySql {

	
	public Connection cn=null;
	public static Connection connexionDB(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
	System.out.println("Connection ok");
			return cn;
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("connection failed");
			return null;
		}
	
		}
	}
