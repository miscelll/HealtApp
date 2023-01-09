package application;

import java.sql.*;
public class ConnectionMySql {

	
	public Connection cn=null;
	public static Connection connexionDB(){
		try {
			//Java program is loading oracle driver to esteblish database connection.
			Class.forName("com.mysql.jdbc.Driver"); 
			
			//The getConnection() method of DriverManager class is used to establish connection with the database
			Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/users","root","");
			
	System.out.println("Connection ok");
			return cn;
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("connection failed");
			return null;
		}
	
		}
	}
