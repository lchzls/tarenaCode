package day03;
import java.util.Scanner;
public class Cashier {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("�����뵥�ۣ�������");
		double unit_price = scan.nextDouble();
		
		System.out.println("������������");
		int number = scan.nextInt();
		
		System.out.println("�������������");
		double amount = scan.nextDouble();
		System.out.println("Ӧ�ս�");
		double price = unit_price*number;
		System.out.println(price);
		System.out.println("����Ϊ��");
		double many = amount-price;
		System.out.println(many);
	}

}
