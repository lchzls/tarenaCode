package test;

import java.lang.reflect.Method;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Test5 {

	static Object method(byte x,double y){
		return (short)x/y*2;
	}
	
	public static void main(String[] args) {
		//byte和short只有当左边是int型时，才不需要强制转型，否则必须强转。
		byte a1=1;
		short b1=2;
		short c1 = (short) (a1+b1);
		byte c2 = (byte) (a1+b1);
		int c3 = a1+b1;
		
//		float f = 1.2; 是错误的
		float f = (float)1.2;
		float f1 =1;
		float f2 = 5;
		
		int i=23;
		int j = 3 & ++i; //0
		
		int m = method();
		System.out.println(m);
		
		
	}
	public static int method(){
		//请注意，这道题，最后输出结果为：
		/*
		 * num is 10
           num is 60
           10
		 */
		int num =10;
		try{
			if(num<20){
				System.out.println("num is 10");
				return num;
			}
			num=40;
		}catch(Exception e){
			num=50;
			System.out.println("num is 50");
		}finally{
			num=60;
			System.out.println("num is 60");
		}
		return num;
	}
}
