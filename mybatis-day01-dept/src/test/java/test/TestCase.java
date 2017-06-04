package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Dept;

public class TestCase {

	private SqlSession session;
	
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(
				TestCase.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
		session = ssf.openSession();
	}
	
	@Test
	public void test1(){
		Dept dept = new Dept();
		dept.setDeptName("manager");
		dept.setLoc("shanghai");
		session.insert("test.save", dept);
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		List<Dept> dept = session.selectList("test.findAll");
		System.out.println(dept);
	}
	
	@Test
	public void test3(){
		Dept dept = session.selectOne("test.findById",1);
		System.out.println(dept);
	}
	
	@Test
	public void test4(){
		Map data  = session.selectOne("test.findById2", 1);
		System.out.println(data.get("LOC"));
		System.out.println(data.get("DEPTNAME"));
	}
	
	@Test
	public void test5(){
		session.delete("test.delete", 1);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		Dept dept = session.selectOne("test.findById", 2);
		System.out.println(dept);
		dept.setLoc("guangzhou1");
		session.update("test.update", dept);
		session.commit();
		session.close();
		
	}
	
}
