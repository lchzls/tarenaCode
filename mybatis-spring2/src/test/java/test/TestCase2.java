package test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DeptDAO;
import dao.EmpDAO;
import entity.Dept;
import entity.Emp;

public class TestCase2 {

	private DeptDAO dao;
	
	@Before 
	public void init(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
//	dao = ac.getBean("empDAO",EmpDAO.class);
	dao = ac.getBean("deptDAO",DeptDAO.class);
	
	}
	
	@Test
	public void test1(){
		Dept dept = new Dept();
		dept.setDeptName("dept2");
		dept.setLoc("Ìì½ò");
		dao.save(dept);
	
	}
	
	@Test
	public void test2(){
		List<Dept> depts = dao.findAll();
		System.out.println(depts);
	}
	
	@Test
	public void test3(){
		Dept dept = dao.findById(2);
		System.out.println(dept);
	}

	@Test
	public void test4(){
		Map data = dao.findById2(2);
		System.out.println(data.get("LOC"));
	}
	
	@Test
	public void test5(){
		dao.delete(2);
		
	}
	
	@Test
	public void test6(){
		Dept dept = dao.findById(3);
		dept.setDeptName("dept3");
		dao.update(dept);
	}
	
}
