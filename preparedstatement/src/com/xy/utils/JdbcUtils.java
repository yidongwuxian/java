package com.xy.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class JdbcUtils {

	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	static{
		try{
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			driver = prop.getProperty("driver");
			   url = prop.getProperty("url");
	      username = prop.getProperty("username");
		  password = prop.getProperty("password");
		    Class.forName(driver);
		}catch(Exception e){
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}

	public static void release(Connection conn, Statement st, ResultSet rs){
		
		if(conn !=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(st !=null){
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(rs !=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;
		}
	}
}
