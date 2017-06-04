package util;

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
			//FileInputStream默认从项目根目录下读文件，但是现在是web项目，文件放在resource下，编译时
			//被编译到了classes下，所以需要从类路径(classes)下读取此文件 
			//prop.load(new FileInputStream("config.properties"));
			prop.load(DBUtil.class.getClassLoader().getResourceAsStream("config.properties"));
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
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
		DBUtil.closeConnection(conn);
	}
	
	
}
