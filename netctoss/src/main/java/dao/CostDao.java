package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Cost;
import util.DBUtil;

public class CostDao implements Serializable {

	public List<Cost> findAll(){
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from cost_lch order by cost_id";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			List<Cost> list = new ArrayList<Cost>();
			while(rs.next()){
				Cost c = createCost(rs);
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ�ʷ�ʧ��",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		//return null;
	}

	//alt+shift+m�����뷽����ΪcreateCost����eclipse�������Զ���ȡ�ɷ���
	private Cost createCost(ResultSet rs) throws SQLException {
		Cost c = new Cost();
		c.setCostId(rs.getInt("cost_id"));
		c.setName(rs.getString("name"));
		c.setBaseDuration(rs.getInt("base_duration"));
		c.setBaseCost(rs.getDouble("base_cost"));
		c.setUnitCost(rs.getDouble("unit_cost"));
		c.setStatus(rs.getString("status"));
		c.setDescr(rs.getString("descr"));
		c.setCreatime(rs.getTimestamp("creatime"));
		c.setStartime(rs.getTimestamp("startime"));
		c.setCostType(rs.getString("cost_type"));
		return c;
	}
	
	public void save(Cost c){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into cost_lch values(cost_seq_lch.nextval,"
					+ "?,?,?,?,'1',?,sysdate,null,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			/*
			 * setInt()��setDouble()��������null����ʵ��ҵ���и��ֶ��ǿ���Ϊ�յġ��������ݿ�
			 * �и��ֶ�Ҳ����Ϊnull��Ҫ����������⣬�轫���ֶε���Object����
			 */
//			ps.setInt(2, c.getBaseDuration());
//			ps.setDouble(3, c.getBaseCost());
//			ps.setDouble(4, c.getUnitCost());	
			ps.setObject(2, c.getBaseDuration());
			ps.setObject(3, c.getBaseCost());
			ps.setObject(4, c.getUnitCost());
			ps.setString(5, c.getDescr());
			ps.setString(6, c.getCostType());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("�����ʷ�ʧ��",e);
		}finally{
			DBUtil.closeConnection(conn);
		}	
	}
	
	public Cost findById(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from cost_lch where cost_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Cost c = new Cost();
			if(rs.next()){
				return createCost(rs);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("����ID��ѯ�ʷ�ʧ��",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return null;
	}
	
	
	public void update(Cost c){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "update cost_lch set name=?,cost_type=?,base_duration=?,"
					+ "base_cost=?,unit_cost=?,descr=? where cost_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getCostType());
			ps.setObject(3, c.getBaseDuration());
			ps.setObject(4, c.getBaseCost());
			ps.setObject(5, c.getUnitCost());
			ps.setString(6, c.getDescr());
			ps.setObject(7, c.getCostId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("�����˺Ų�ѯ����Աʧ��",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
	
	public void delete(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from cost_lch where cost_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("�����˺Ų�ѯ����Աʧ��",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		
	}
	
	public static void main(String[] args) {
//		CostDao dao  = new CostDao();
//		List<Cost> list = dao.findAll();
//		for(Cost c:list){
//			System.out.println(c.getCostId()+","+c.getName());
//		}
		
//		CostDao dao  = new CostDao();
//		Cost c = new Cost();
//		c.setName("66Ԫ�ײ�");
//		//c.setBaseDuration(660);
//		//c.setBaseCost(66.0);
//		//c.setUnitCost(0.6);
//		c.setDescr("66Ԫ�ײͺܻ���");
//		c.setCostType("2");
//		dao.save(c);
		
		
		CostDao dao = new CostDao();
		Cost c = dao.findById(1);
		if(c!=null){
			System.out.println(c.getName());
		}
	}
	
}
