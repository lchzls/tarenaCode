package web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener {

	//tomcat������requestʱ�Զ����ø÷�����֪ͨ������request������
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("����request");
	}

	/*
	 * tomcat�ڴ���requestʱ���Զ����ø÷�����֪ͨ������request��ʼ���ˣ������������ﴦ����ص�ҵ��
	 * �������¼�������tomcat��������ֵ������
	 * 
	 */
	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("��ʼ��request");
	    System.out.println(e.getServletRequest());
	}

}
