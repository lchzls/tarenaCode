package day09;
/**
 * 守护线程，又称为后台线程
 * 使用上与前台线程一致。但是在结束时机上，有一个
 * 例外，即:进程结束时，会强制将运行的后台线程停止
 * 进程结束:当一个进程中的所有前台线程都结束了，
 *         那么进程就会结束。
 * 默认创建的线程都是前台线程，后台线程需要单独
 * 进行设置，线程提供了方法:
 * void setDaemon(boolean tf)
 * 若参数为true,则该线程为守护线程(后台线程)        
 * @author adminitartor
 *
 */
public class ThreadDemo8 {
	public static void main(String[] args) {
		/*
		 * rose:前台线程
		 */
		Thread rose = new Thread(){
			public void run(){
				for(int i=0;i<5;i++){
					System.out.println(
						"rose:let me go!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose:啊啊啊啊啊AAAAAAaaaa.....");
				System.out.println("音效:噗通!");
			}
		};
		
		Thread jack = new Thread(){
			public void run(){
				while(true){
					System.out.println(
						"jack:you jump!i jump!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		//在线程启动前设置
		jack.setDaemon(true);
		
		rose.start();
		jack.start();
		
	}
}







