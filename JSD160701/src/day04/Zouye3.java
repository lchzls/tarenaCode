package day04;

import java.util.Scanner;

public class Zouye3 {
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 System.out.println("请输入chioce:1,2,3");
		 int chioce = scan.nextInt();
		 switch(chioce){
		 case 1:System.out.println("请购物");
		 break;
		 case 2:System.out.println("购物结算");
		 break;
		 case 3:System.out.println("欢迎下次光临");
		 break;
		 default:
			System.out.println("输入有误"); 
		 }
	}
}
