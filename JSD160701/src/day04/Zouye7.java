package day04;
import java.util.Scanner;
public class Zouye7 {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("请依次输入三个整数：a,b,c (以空格隔开)");
	int a=scan.nextInt();
	int b=scan.nextInt();
	int c=scan.nextInt();
	int max=(a>b?a:b)<c?c:(a>b?a:b);
	System.out.println("最大值"+max);
}
}
