package day04;

import java.util.Scanner;

public class Zouye6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("��������ݣ����� 2012");
		int year = scan.nextInt();
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year+"������");
		} else {
			System.out.println(year+"��������");
		}
	}
}
