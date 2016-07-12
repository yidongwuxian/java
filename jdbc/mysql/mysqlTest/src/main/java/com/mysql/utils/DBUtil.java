package com.mysql.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
	private static final String UNAME = "root";
	private static final String PWD = "123456";
	
	private static Connection conn = null;
	 
	  static
	  {
	    try
	    {
	      // 1.������������
	      Class.forName("com.mysql.jdbc.Driver");
	      // 2.������ݿ������
	      conn = DriverManager.getConnection(URL, UNAME, PWD);
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	    }
	  }
	 
	  public static Connection getConnection()
	  {
	    return conn;
	  }
}