package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmpDAO;
import entity.Emp;

public class TestCase {

	private EmpDAO dao ;
	
	@Before
	public void init(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = ac.getBean("empDAO",EmpDAO.class);
	}
	
	@Test
	public void test1(){
		Emp emp = new Emp();
		emp.setEname("Sally");
		emp.setAge(22);
		dao.save(emp);
	}
	
	@Test
	public void test2(){
		List<Emp> emps = dao.findAll();
		System.out.println(emps);
	}
	
	@Test
	public void test3(){
		Emp emp = dao.findById2(300);
		System.out.println(emp);
	}
	
	@Test
	public void test4(){
		//���ҳ�Ҫ�޸ĵ�Ա����Ϣ
		Emp emp = dao.findById2(300);
		//Ȼ���޸�
		emp.setAge(emp.getAge()*2);
		//�������ݿ�
		dao.modify(emp);
	}
	
	@Test
	public void test5(){
		System.out.println(dao.findAll());
		dao.delete(300);
		System.out.println(dao.findAll());
	}
	
}
