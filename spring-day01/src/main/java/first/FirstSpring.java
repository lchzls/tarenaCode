package first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
	public static void main(String[] args) {
	//����spring����
		/*
		 * ApplicationContext���ӿ�
		 * ClassPathXmlApplicationContextʵ����ApplicationContext�ӿڵ���
		 * ע�⣺�����ļ���·�����ļ�����spring����������ʱ����Ҫ��ȡ�����ļ�
		 */
		
	ApplicationContext ac =
			new ClassPathXmlApplicationContext("applicationContext.xml");
	System.out.println(ac);
	
	}
}
