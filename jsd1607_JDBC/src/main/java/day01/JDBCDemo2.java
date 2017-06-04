package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//创建一个序列seq_userinfo_id
public class JDBCDemo2 {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		    Statement state = conn.createStatement();
		    String sql = "create sequence seq_userinfo_id  "
		    		+ " start with 1 "
		    		+ " increment by 1";
		    System.out.println(sql);
		    state.execute(sql);
		    System.out.println("ok");
		    conn.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
}
