package day04;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 泛型是编译器认可，
 * 泛型让编译器做了两件事:
 * 1:当给泛型赋值时，编译器会检查实际数据与泛型
 *   类型是否一致，不一致则编译不通过
 * 2:当获取泛型的值时，那么编译器会补充造型代码
 *   做类型转换
 * 而泛型的实际类型会被编译器改为Object    
 * @author adminitartor
 *
 */
public class TestPoint {
	public static void main(String[] args) {
		Point<Integer> p1 
			= new Point<Integer>(1,2);
		p1.setX(2);
		int x1 = p1.getX();
		System.out.println(p1);
		
		Point<Double> p2 
			= new Point<Double>(1.1,2.2);
		double x2 = p2.getX();
		System.out.println(p2);
		
		Point<String> p3 
			= new Point<String>("一","二");
		p3.setX("二");
		String x3 = p3.getX();
		

	}
	
}
