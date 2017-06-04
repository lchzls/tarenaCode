package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmpDAO;
import entity.Emp;
import entity.Emp2;

public class TestCase {

	private SqlSession session;
	private EmpDAO dao;
	
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf =
				ssfb.build(TestCase.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
	    session = ssf.openSession();
	    dao = session.getMapper(EmpDAO.class);
	}
	
	@Test
	public void test1(){
		/*
		 * getMapper������mybatis����Mapperӳ����������ӳ���ļ��Ľӿڣ�Ҫ�����ɷ��Ͻӿ�Ҫ��Ķ���
		 * 
		 */
		Emp emp = new Emp();
		emp.setEname("John");
		emp.setAge(22);
		dao.save(emp);
		session.commit();
		session.close();
		
	}
	
	@Test
	public void test2(){
		List<Emp> emps = dao.findAll();
		System.out.println(emps);
		session.close();
	}
	
	@Test
	public void test3(){
		Emp emp = dao.findById(700);
		System.out.println(emp);
		session.close();
	}
	
	@Test
	public void test4(){
		Emp emp = dao.findById(700);
		emp.setAge(emp.getAge()+20);
		dao.modify(emp);
		session.commit();
		session.close();
	}

	@Test
	public void test5(){
		dao.delete(700);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		Map data = dao.findById2(510);
		System.out.println(data.get("ENAME"));
		session.close();
	}
	
	@Test
	public void test7(){
		Emp2 emp = dao.findById3(510);
		System.out.println(emp);
		session.close();
	}
	
	
}
