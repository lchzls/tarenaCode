package oo.day05;

public interface B {

	//接口中不能有构造方法
//	public B(){
//		
//	}
	
//接口中的方法必须是抽象的？ 不是的，可以有静态方法体
 default void b() {
  
  }
	
//  int a ;
  
  static int a= 6;
}
