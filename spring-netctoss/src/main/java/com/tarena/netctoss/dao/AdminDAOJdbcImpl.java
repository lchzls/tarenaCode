package com.tarena.netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.tarena.netctoss.entity.Admin;

@Repository("adminDAO")
//�־ò�
public class AdminDAOJdbcImpl implements AdminDAO {

	@Resource(name="ds")
	private DataSource ds;
	
	public Admin findByAdminCode(String adminCode) {
		Admin admin = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from admin_info_lch where admin_code=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, adminCode);
			rs=ps.executeQuery();
			if(rs.next()){
				admin= new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminCode(rs.getString("admin_code"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setTelephone(rs.getString("telephone"));
				admin.setEmail(rs.getString("email"));
				admin.setEnrolldate(rs.getTimestamp("enrolldate"));
				return admin;
			}
		} catch (SQLException e) {
			//����־
			e.printStackTrace();
			/*
			 * ���쳣�Ƿ��ܹ��ָ�������ܹ��ָ����������ָ���������ܹ��ָ�
			 * �����磬������ϵͳ�쳣:���ݿ������ͣ�������жϵȣ�������ʾ�û��Ժ�����
			 */
			throw new RuntimeException(e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return null;
	}

}
