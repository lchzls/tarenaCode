package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.DeptDAO;
import entity.Dept;

public class TestCase2 {

	private SqlSession session;
	private DeptDAO dao;
	
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = 
				ssfb.build(TestCase2.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
		session = ssf.openSession();
		dao = session.getMapper(DeptDAO.class);
	
	}
	
	@Test
	public void test1(){
		Dept dept = new Dept();
		dept.setDeptName("dept1");
		dept.setLoc("guangzhou");
		dao.save(dept);
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		List<Dept> dept = dao.findAll();
		System.out.println(dept);
		session.close();
	}
	
	@Test
	public void test3(){
		Dept dept = dao.findById(21);
		System.out.println(dept);
		session.close();
	}
	
	@Test
	public void test4(){
		Map data = dao.findById2(21);
		System.out.println(data.get("LOC"));
		session.close();
	}
	
	@Test
	public void test5(){
		dao.delete(21);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		Dept dept = dao.findById(3);
		dept.setLoc("beijing");
		dao.update(dept);
		session.commit();
		session.close();
	}
}
