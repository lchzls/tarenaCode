package day04;

import java.util.Scanner;

public class Zouye3 {
	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
		 System.out.println("������chioce:1,2,3");
		 int chioce = scan.nextInt();
		 switch(chioce){
		 case 1:System.out.println("�빺��");
		 break;
		 case 2:System.out.println("�������");
		 break;
		 case 3:System.out.println("��ӭ�´ι���");
		 break;
		 default:
			System.out.println("��������"); 
		 }
	}
}
