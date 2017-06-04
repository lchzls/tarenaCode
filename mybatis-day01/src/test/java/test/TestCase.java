package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Emp;
import entity.Emp2;

public class TestCase {

	private SqlSession session;
	@Before
	public void init(){
		//类加载器ClassLoader
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				/*
				 * getResourceAsStream是ClassLoader提供的一个方法，负责读取配置文件的内容，并提供一个输入流（inputStream)
				 * 注：ClassLoader（类加载器）:负责读取类的字节码文件，并将这些内容转换成方法区中的class对象
				 */
				SqlSessionFactory ssf = 
						ssfb.build(TestCase.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
				session = ssf.openSession();
	}
	
	@Test
	public void test1(){
		
		Emp emp = new Emp();
		emp.setEname("Tom");
		emp.setAge(22);
		session.insert("test.save", emp);
		//提交事务
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		List<Emp> emps = session.selectList("test.findAll");
		System.out.println(emps);
		session.close();//这里不需要提交事务，因为查询不需要提交
	}
	
	@Test
	public void test3(){
		Emp emp = session.selectOne("test.findById",500);
		System.out.println(emp);
		session.close();//这里不需要提交事务，因为查询不需要提交
	}
	
	@Test
	public void test4(){
		Emp emp = session.selectOne("test.findById", 500);
		emp.setAge(emp.getAge()+10);
		session.update("test.modify", emp);
		session.commit();
		session.close();
	}
	
	@Test
	public void test5(){
		session.delete("test.delete",500);
		session.commit();
		session.close();
	}
	
	@Test
	public void test6(){
		Map data = session.selectOne("test.findById2", 510);
		//注意，字段名要大写，oracle会将字段名都转换为大写形式
		System.out.println(data.get("ENAME"));
	}
	
	
	@Test
	public void test7(){
		Emp2 emp = session.selectOne("test.findById3", 510);
		System.out.println(emp);
	}
	
}
