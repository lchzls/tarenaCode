package day02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {

	private static BasicDataSource ds;
//	private static String className;
//	private static String url;
//	private static String username;
//	private static String password;
	
	static{
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
			String className = prop.getProperty("classname");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			int maxActive = Integer.parseInt(prop.getProperty("maxactive"));
			int maxWait = Integer.parseInt(prop.getProperty("maxwait"));
			ds = new BasicDataSource();
			ds.setDriverClassName(className);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setMaxActive(maxActive);	
			ds.setMaxWait(maxWait);
		
			
//			System.out.println(className);
//			System.out.println(url);
//			System.out.println(username);
//			System.out.println(password);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception{
//		Class.forName(className);
//		Connection conn = DriverManager.getConnection(url,username,password);
//		return conn;
		return ds.getConnection();
		
	}
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try {
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
