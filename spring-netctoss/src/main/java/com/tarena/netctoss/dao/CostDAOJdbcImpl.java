package com.tarena.netctoss.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.tarena.netctoss.entity.Cost;

@Repository("costDAO")
public class CostDAOJdbcImpl implements CostDAO {

	@Resource(name="ds")
	private DataSource ds;
	
	public List<Cost> findAll()  {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Cost> list = null;
		Cost c = null;
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			String sql = "select * from cost_lch order by cost_id";
			rs = st.executeQuery(sql);
			list = new ArrayList<Cost>();
			c = new Cost();
			while(rs.next()){
				c = createCost(rs);
				list.add(c);
			}
			return list;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	
	}
	
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
	

}
