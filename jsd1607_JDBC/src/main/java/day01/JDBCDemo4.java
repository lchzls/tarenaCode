package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo4 {

	public static void main(String[] args) {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			Statement state = conn.createStatement();
			String sql = "select id,username,password,email,nickname,account "
					+ "from userinfo_lch ";
			System.out.println(sql);
			ResultSet rs = state.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt("id")+","+rs.getString("username")+","+rs.getString("password")+","+rs.getString("email")+","+rs.getString("nickname")+","+rs.getInt("account"));
//				System.out.print(rs.getString("username"));
//				System.out.println(rs.getString("password"));
//				System.out.println(rs.getString("email"));
//				System.out.println(rs.getString("nickname"));
//				System.out.println(rs.getInt("account"));
				
			}
			System.out.println("ok");
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
