package day04;

import java.util.Scanner;

public class Zouye4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入两个整数:a,b（以空格隔开）");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int max = a > b ? a : b;
		System.out.println("最大值为" + max);

	}
}
