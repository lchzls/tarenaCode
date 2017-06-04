package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import day02.DBUtil;

/**
 * 使用PS完成对userinfo表中数据的分页显示
 * @author adminitartor
 *
 */
public class JDBCDemo3 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入start:");
			int start = scanner.nextInt();
			System.out.println("请输入end:");
			int end = scanner.nextInt();
			String sql = "select * from "
					+ "(select rownum rn,id,username,password,email,nickname,account from userinfo_lch "
					+ "where rownum<=?) where rn>=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, end);
			ps.setInt(2, start);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int rn = rs.getInt("rn");
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String nickname = rs.getString("nickname");
				double account = rs.getDouble("account");
				System.out.println(rn+" "+id+" "+username+" "+password+" "+email+" "+nickname+" "+account);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(conn!=null){
				DBUtil.closeConnection(conn);
			}
		}
	}
}
