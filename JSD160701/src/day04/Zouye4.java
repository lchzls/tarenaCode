package day04;

import java.util.Scanner;

public class Zouye4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("��������������:a,b���Կո������");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int max = a > b ? a : b;
		System.out.println("���ֵΪ" + max);

	}
}
