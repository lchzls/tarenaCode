package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import day01.UserInfo;
import day02.DBUtil;

public class UserInfoDAOImp implements UserInfoDAO {

	public boolean save(UserInfo userinfo) {
		//由于是连接池，因此需要都设置为空，最后将其都关闭
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn  = DBUtil.getConnection();
			String sql = "insert into userinfo_lch(id,username,password,email,nickname,account) "
					+ "values(seq_userinfo_id.nextval,?,?,?,?,?)";
			ps  = conn.prepareStatement(sql,new String[]{"id"});
			ps.setString(1, userinfo.getUsername());
			ps.setString(2, userinfo.getPassword());
			ps.setString(3, userinfo.getEmail());
			ps.setString(4, userinfo.getNickname());
			ps.setDouble(5, userinfo.getAccount());
			
			int i = ps.executeUpdate();
			if(i>0){
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				int id = rs.getInt(1);
				userinfo.setId(id);
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
			DBUtil.closeConnection(conn);
			}
		}
		return false;
	}

	public UserInfo findByName(String username) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select id ,username,password,email,nickname,account from userinfo_lch where username=? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int id = rs.getInt("id");
				String user = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String nickname = rs.getString("nickname");
				double account = rs.getDouble("account");
				UserInfo userinfo = new UserInfo(id,user,password,email,nickname,account);
				return userinfo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(conn!=null){
			DBUtil.closeConnection(conn);
			}
		}
		return null;
	}

	public List<UserInfo> findAll() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Statement state  = conn.createStatement();
			String sql = "select id,username,password,email,nickname,account from userinfo_lch";
			ResultSet rs = state.executeQuery(sql);
			List<UserInfo> list = new ArrayList<UserInfo>();
			while(rs.next()){
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String nickname = rs.getString("nickname");
				double account = rs.getDouble("account");
				
				UserInfo userinfo = new UserInfo(id,username,password,email,nickname,account);
	            
				list.add(userinfo);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		
			if(conn!=null){
			DBUtil.closeConnection(conn);
			}
		}
		return null;
	
	}

	
	public List<UserInfo> findAllByPage(int pagesize, int page) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from "
					+ "(select rownum rn,id,username,password,email,nickname,account from userinfo_lch "
					+ "where rownum<=?) where rn>=? ";
			ps = conn.prepareStatement(sql);
			int end = page*pagesize;
			int start = (page-1)*pagesize+1;
			ps.setInt(1, end);
			ps.setInt(2, start);
			ResultSet rs = ps.executeQuery();
			List<UserInfo> list = new ArrayList<UserInfo>();
			while(rs.next()){
//				int rn = rs.getInt("rn");
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String nickname = rs.getString("nickname");
				double account = rs.getDouble("account");
				UserInfo userinfo = 
						new UserInfo(id,username,password,email,nickname,account);
				list.add(userinfo);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(conn!=null){
			DBUtil.closeConnection(conn);
			}
		}
		return null;
	}

	public boolean update(UserInfo userinfo) {
		//由于是连接池，因此需要都设置为空
				Connection conn = null;
				PreparedStatement ps = null;
				try {
					conn  = DBUtil.getConnection();
					String sql = "update userinfo_lch set username=?,password=?,email=?,nickname=?,account=? where id = ?";
					ps  = conn.prepareStatement(sql);
					ps.setString(1, userinfo.getUsername());
					ps.setString(2, userinfo.getPassword());
					ps.setString(3, userinfo.getEmail());
					ps.setString(4, userinfo.getNickname());
					ps.setDouble(5, userinfo.getAccount());
					ps.setInt(6, userinfo.getId());
					int i = ps.executeUpdate();
					if(i>0){
						System.out.println("修改成功！");
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					if(ps!=null){
						try {
							ps.close();
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
					}
					if(conn!=null){
					DBUtil.closeConnection(conn);
					}
				}
				return false;
	}

	public boolean updateForTransfor(UserInfo u1, UserInfo u2) {
		Connection conn = null;
		PreparedStatement outPs = null;
		PreparedStatement inPs = null;
		try {
			conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

			//转出的sql
			String outSql = "UPDATE userinfo_lch "
					      + "SET account=? "
					      + "WHERE username=?";
			outPs
				= conn.prepareStatement(outSql);
			outPs.setDouble(1, u1.getAccount());
			outPs.setString(2, u1.getUsername());
			outPs.executeUpdate();
			
			
			//转入的sql
			String inSql = "UPDATE userinfo_lch "
					     + "SET account=? "
					     + "WHERE username=?";
			inPs
				= conn.prepareStatement(inSql);
			inPs.setDouble(1, u2.getAccount());
			inPs.setString(2, u2.getUsername());
			inPs.executeUpdate();
			conn.commit();
			return true;

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteById(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from userinfo_lch "
					   + "where id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i>0){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(conn!=null){
			DBUtil.closeConnection(conn);
			}
		}
		return false;
	}

	

	//查看当前用户余额（只有登录后才可以查看）
	public void showAccout(UserInfo userinfo) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select account from userinfo_lch where username=?";
			ps  = conn.prepareStatement(sql);
			ps.setString(1, userinfo.getUsername());
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				System.out.println(userinfo.getUsername()+"余额为:"+rs.getDouble("account"));
				return ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(conn!=null){
			DBUtil.closeConnection(conn);
			}
		}
	}
	
	public static void main(String[] args) {
		//用于测试上面的方法是否正确，正确后再在UserService中去调用,如delete方法
		UserInfo u = new UserInfo(61,"111","111","123","123",6000);
		UserInfoDAO dao = new UserInfoDAOImp();
		boolean f = dao.deleteById(23);
		if(f){
			System.out.println("delete ok");
		}else{
			System.out.println("delete not ok");
		}
	}


}
