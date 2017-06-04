package test;

public class test1 {
/*
 * 面试题：请问输出的顺序依次为：？
 * 
 */
	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				pong();
			}
		};
        t.run();
        System.out.println("ping");
	}


	static void pong(){
		System.out.println("pang");
	}
}