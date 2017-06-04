package day03;
import java.util.Scanner;
public class Cashier {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入单价：（￥）");
		double unit_price = scan.nextDouble();
		
		System.out.println("请输入数量：");
		int number = scan.nextInt();
		
		System.out.println("请输入金额：（￥）");
		double amount = scan.nextDouble();
		System.out.println("应收金额：");
		double price = unit_price*number;
		System.out.println(price);
		System.out.println("找零为：");
		double many = amount-price;
		System.out.println(many);
	}

}
