package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 要求输入一个id，然后删除对应的用户
 * 使用PreparedStatement完成
 * @author adminitartor
 *
 */
public class JDBCDemo3 {
	
   public static void main(String[] args) {
	   Connection conn = null;
		try {
			System.out.println("input id:");
			Scanner scanner = new Scanner(System.in);
			int id  = scanner.nextInt();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			
			//使用PreparedStatement
			String sql = "delete from userinfo_lch "
					   + "where id=?";
			PreparedStatement ps 
				= conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i>0){
				System.out.println("删除成功!");
			}else{
				System.out.println("删除失败");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
}
