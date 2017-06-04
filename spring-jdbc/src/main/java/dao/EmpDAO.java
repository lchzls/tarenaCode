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
	 * spring jdbc���ײ��jdbc�쳣����֮��ͳһת������һЩ����ʱ�쳣RuntimeException,Ȼ���׳������Ǽ���쳣��������Ϊ
	 * û�д����쳣�����ֱ��������Ϣ
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
	 * RowMapper���װ����ν���¼ת��Ϊ��Ӧ��ʵ�����
	 */
	class EmpRowMapper implements RowMapper<Emp>{

		//index�����ڱ������ļ�¼���±�
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
	 * queryForObject����:����Ҳ�����Ӧ�ļ�¼�����׳��쳣��������봦�������findById2�ķ�ʽ�ദ��
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
