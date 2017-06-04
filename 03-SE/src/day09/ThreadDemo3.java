package day09;
/**
 * 使用匿名内部类的形式按照线程的两种创建方式
 * 分别创建线程
 * @author adminitartor
 *
 */
public class ThreadDemo3 {
	public static void main(String[] args) {
		//方式一的匿名内部类形式创建
		new Thread(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("你是谁啊?");
				}
			}
		}.start();
		
		//方式二的匿名内部类形式创建
		new Thread(new Runnable(){
			public void run(){
				for(int i=0;i<1000;i++){
					System.out.println("我是查水表的!");
				}
			}
		}).start();	
	}
}







