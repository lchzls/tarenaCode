package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			List<Cost> list = new ArrayList();
			while(rs.next()){
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
				list.add(c);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询失败",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		//return null;
		
	}
	
	
	public void  save(Cost c){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//String sql = "insert into cost_lch values(cost_seq_lch.nextval,?,?,?,?,'1',?,sysdate,null,?)";
			String sql = "insert into cost_lch values(cost_seq_lch.nextval,"
					+ "?,?,?,?,'1',?,sysdate,null,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setObject(2, c.getBaseDuration());
			ps.setObject(3, c.getBaseCost());
			ps.setObject(4, c.getUnitCost());
			ps.setString(5, c.getDescr());
			ps.setString(6, c.getCostType());
			ps.executeUpdate();
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("添加失败",e);
			
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	
	
	public static void main(String[] args) {
		CostDao dao = new CostDao();
//		List<Cost> list = dao.findAll();
//		for(Cost c:list){
//			System.out.println(c.getName());
//		}
		
		Cost c = new Cost();
		c.setName("李");
		c.setDescr("好好好");
		c.setCostType("2");
		dao.save(c);
		
	}
	
}
