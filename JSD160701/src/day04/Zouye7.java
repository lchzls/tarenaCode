package day04;
import java.util.Scanner;
public class Zouye7 {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("��������������������a,b,c (�Կո����)");
	int a=scan.nextInt();
	int b=scan.nextInt();
	int c=scan.nextInt();
	int max=(a>b?a:b)<c?c:(a>b?a:b);
	System.out.println("���ֵ"+max);
}
}
