package web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyListener implements ServletRequestListener {

	//tomcat在销毁request时自动调用该方法，通知开发者request销毁了
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("销毁request");
	}

	/*
	 * tomcat在创建request时会自动调用该方法，通知开发者request初始化了，开发者在这里处理相关的业务
	 * 参数是事件对象，由tomcat创建、赋值并传入
	 * 
	 */
	public void requestInitialized(ServletRequestEvent e) {
		System.out.println("初始化request");
	    System.out.println(e.getServletRequest());
	}

}
