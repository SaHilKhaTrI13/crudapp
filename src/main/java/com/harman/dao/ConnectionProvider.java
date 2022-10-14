package com.harman.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.harman.exception.PersonException;

class ConnectionProvider {
	private static Connection con=null;
	private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/harman";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Sahil";
	
	
//	for creating singltono design pettern we must creat static member holds only one instance of the ConnectionProvider class
	private static ConnectionProvider jdbc;
	
//	Secon step for creating singleton design pettern is create constructor as private;
	private ConnectionProvider() {}
	
//	Third step is provide globel point of access;
    public static ConnectionProvider getInstance() {    
        if (jdbc==null)  
      {  
               jdbc=new  ConnectionProvider();  
      }  
		return jdbc;  
		}  
	public static Connection getConnection() throws  PersonException 
	{
		try {
			Class.forName(DRIVERNAME);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(Exception excep)
		{
			System.out.print(excep);
		}
		return con;
	}
}
