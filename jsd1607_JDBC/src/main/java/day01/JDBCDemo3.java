package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCDemo3 {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn =
					DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			Statement state = conn.createStatement();
			Scanner scan = new Scanner(System.in);
			System.out.println("��ӭע��");
			System.out.println("�������û���");
			String username = scan.next();
			System.out.println("����������");
			String password = scan.next();
			System.out.println("����������");
			String email = scan.next();
			System.out.println("�������ǳ�");
			String nickname = scan.next();
			System.out.println("���������");
			int account = Integer.parseInt(scan.next());
			
//			String sql = "insert into userinfo_lch "
//					   + "(id,username,password,email,nickname,account) "
//					   + "values "
//					   + "(seq_userinfo_id.nextval,'jack','1234','78910','����',12345) ";

			String sql = "insert into userinfo_lch "
					   + "(id,username,password,email,nickname,account) "
					   + "values "
					   + "(seq_userinfo_id.nextval,'"+username+"','"+password+"','"+email+"','"+nickname+"',"+account+") ";
			
			//			String sql = "insert into userinfo_lch"
//					+ "(id,username,password,email,nickname,account) "
//					+ "values"
//					+ "(seq_userinfo_id.nextval,'"+username+"','"+password
//					+"','"+email+"','"+nickname+"',"+account+")";
			System.out.println(sql);
			int i  = state.executeUpdate(sql);
			
			if(i>0){
				System.out.println("����һ��");
				System.out.println("ok");
			}
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
