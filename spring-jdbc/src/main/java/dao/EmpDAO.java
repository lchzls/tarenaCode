package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Emp;

@Repository("empDAO")
public class EmpDAO {

	@Resource(name="jt")
	private JdbcTemplate jt;
	
	/*
	 * spring jdbc将底层的jdbc异常捕获之后统一转换成了一些运行时异常RuntimeException,然后抛出。即非检查异常，不会因为
	 * 没有处理异常而出现编译错误信息
	 */
	public void save(Emp emp){
		String sql = "insert into emp1_lch values(emp_seq.nextval,?,?)";
		Object[] args = new Object[]{emp.getEname(),emp.getAge()};
		jt.update(sql, args);
	}
	
	public List<Emp> findAll(){
		String sql = "select * from emp1_lch";
		return jt.query(sql, new EmpRowMapper());
		
	}
	
	/*
	 * RowMapper类封装了如何将记录转换为相应的实体对象
	 */
	class EmpRowMapper implements RowMapper<Emp>{

		//index：正在被遍历的记录的下标
		public Emp mapRow(ResultSet rs, int index) 
				throws SQLException {
			Emp emp = new Emp();
			emp.setId(rs.getInt("id"));
			emp.setEname(rs.getString("ename"));
			emp.setAge(rs.getInt("age"));
			return emp;
		}	
	}
	
	/*
	 * queryForObject方法:如果找不到对应的记录，会抛出异常。如果不想处理可以用findById2的方式类处理
	 */
	public Emp findById(int id){
		String sql = "select * from emp1_lch where id=?";
		Object[] args = new Object[]{id};
		return jt.queryForObject(sql, args, new EmpRowMapper());
	}
	
	
	public Emp findById2(int id){
		String sql = "select * from emp1_lch where id=?";
		Object[] args = new Object[]{id};
		List<Emp> emps = jt.query(sql, args,new EmpRowMapper());
		if(emps!=null&&emps.size()>0){
			return emps.get(0);
		}
		return null;
	}
	
	public void modify(Emp emp){
		String sql =" update emp1_lch set ename=? ,age =? where id=?";
		Object[] args = new Object[]{emp.getEname(),emp.getAge(),emp.getId()};
		jt.update(sql,args);
	}
	
	public void delete(int id){
		String sql ="delete from emp1_lch where id=?";
		Object[] args = new Object[]{id};
		jt.update(sql, args);
	}
	
}
