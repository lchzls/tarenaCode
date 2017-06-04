package day04;

import java.util.Scanner;

public class Zouye {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入单价：（￥）");
		double unit_price = scan.nextDouble();
		
		System.out.println("请输入数量：");
		double number = scan.nextDouble();
		
		System.out.println("请输入金额：（￥）");
		double amount = scan.nextDouble();
		System.out.println("应收金额：");
		double price = unit_price*number;
		if(price>499){
			price=price-100;
		}
		System.out.println(price);
		System.out.println("找零为：");
		double many = amount-price;
		System.out.println(many);
		
	}
}
