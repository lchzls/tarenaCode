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
		//�������ClassLoader
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				/*
				 * getResourceAsStream��ClassLoader�ṩ��һ�������������ȡ�����ļ������ݣ����ṩһ����������inputStream)
				 * ע��ClassLoader�����������:�����ȡ����ֽ����ļ���������Щ����ת���ɷ������е�class����
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
		//�ύ����
		session.commit();
		session.close();
	}
	
	@Test
	public void test2(){
		List<Emp> emps = session.selectList("test.findAll");
		System.out.println(emps);
		session.close();//���ﲻ��Ҫ�ύ������Ϊ��ѯ����Ҫ�ύ
	}
	
	@Test
	public void test3(){
		Emp emp = session.selectOne("test.findById",500);
		System.out.println(emp);
		session.close();//���ﲻ��Ҫ�ύ������Ϊ��ѯ����Ҫ�ύ
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
		//ע�⣬�ֶ���Ҫ��д��oracle�Ὣ�ֶ�����ת��Ϊ��д��ʽ
		System.out.println(data.get("ENAME"));
	}
	
	
	@Test
	public void test7(){
		Emp2 emp = session.selectOne("test.findById3", 510);
		System.out.println(emp);
	}
	
}
